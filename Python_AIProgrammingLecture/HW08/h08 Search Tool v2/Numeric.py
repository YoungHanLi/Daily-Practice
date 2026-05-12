import random
import math
from Problem import Problem

class Numeric(Problem):
    def __init__(self):
        super().__init__()
    
    DELTA = 0.01   # Mutation step size
    EPSILON = 0.0001
    
    def createProblem(self):
        ## Read in an expression and its domain from a file.
        ## Then, return a problem.
        fileName = input("Enter the file name of a function: ")
        infile = open(fileName, 'r')
        expression = infile.readline() # as a string
        varNames = []  # Variable names
        low = []       # Lower bounds
        up = []        # Upper bounds
        line = infile.readline()
        while line != '':
            data = line.split(',')  # read from CSV
            varNames.append(data[0])
            low.append(float(data[1]))
            up.append(float(data[2]))
            line = infile.readline()
        infile.close()
        domain = [varNames, low, up]
        return expression, domain

    def execute(self):
        # Create an instance of numerical optimization problem
        p = self.createProblem()   # 'p': (expr, domain)
        # Call the search algorithm
        solution, self.result = self.Algorithm(p)
        # Show the problem and algorithm settings
        self.describeProblem(p)
        self.displaySetting()
        # Report results
        self.displayResult(solution, self.result)

    def Algorithm(self, p):
        neighbors = []
        current = self.gradientDescent(self.randomInit(p), p) # 'current' is a list of values
        valueC = self.evaluate(current, p)
        i = 0
        while i < 700:
            successor = self.gradientDescent(self.randomInit(p), p)
            valueS = self.evaluate(successor, p)
            if valueS < valueC:
                current = successor
                valueC = valueS
                i = 0
            else:
                i += 1
#        for i in range(200):
#            neighbors.append(self.gradientDescent(p))
#            successor, valueS = self.bestOf(neighbors, p)
#            if valueS < valueC:
#                current = successor
#                valueC = valueS
        return current, valueC

    def gradientDescent(self, current, p):
        descentC = self.derivative(current, p)
        while True:
            neighbors = self.mutants(current, p)
            successor, descentS = self.bestOfDerivateive(neighbors, p)
            if descentS >= descentC:
                break
            else:
                current = successor
                descentC = descentS
        return current       

    def randomInit(self, p): # Return a random initial point as a list
        domain = p[1]  # domain: [varNames, low, up]
        low, up = domain[1], domain[2]
        init = []
        for i in range(len(low)):              # For each variable
            r = random.uniform(low[i], up[i])  # take a random value
            init.append(r)
        return init    # list of values

    def evaluate(self, current, p):
        ## Evaluate the expression of 'p' after assigning
        ## the values of 'current' to the variables
        self.NumEval += 1
        expr = p[0]         # p[0] is function expression
        varNames = p[1][0]  # p[1] is domain
        for i in range(len(varNames)):
            assignment = varNames[i] + '=' + str(current[i])
            exec(assignment)
        return eval(expr)

    def derivative(self, current, p):
        curCopy = current[:]
        for i in range(len(current)):
            self.mutate(curCopy, i, self.EPSILON, p)
        f1 = self.evaluate(curCopy, p)
        f2 = self.evaluate(current, p)
        derivativedValue = (f1 - f2) / self.EPSILON
        return derivativedValue

    def mutants(self, current, p):
        neighbors = []
        for i in range(len(current)):  # For each variable
            mutant = self.mutate(current, i, self.DELTA, p)
            neighbors.append(mutant)
            mutant = self.mutate(current, i, -(self.DELTA), p)
            neighbors.append(mutant)
        return neighbors

    def mutate(self, current, i, d, p): ## Mutate i-th of 'current' if legal
        curCopy = current[:]
        domain = p[1]        # [VarNames, low, up]
        l = domain[1][i]     # Lower bound of i-th
        u = domain[2][i]     # Upper bound of i-th
        if l <= (curCopy[i] + d) <= u:
            curCopy[i] += d
        return curCopy

    def bestOf(self, neighbors, p):
        best = neighbors[0]  # 'best' is a value list
        bestValue = self.evaluate(best, p)
        for i in range(1, len(neighbors)):
            newValue = self.evaluate(neighbors[i], p)
            if newValue < bestValue:
                best = neighbors[i]
                bestValue = newValue
        return best, bestValue

    def bestOfDerivateive(self, neighbors, p):
        best = neighbors[0]  # 'best' is a value list
        bestDerivateive = self.derivative(best, p)
        for i in range(1, len(neighbors)):
            newDerivative = self.derivative(neighbors[i], p)
            if newDerivative < bestDerivateive:
                best = neighbors[i]
                bestDerivateive = newDerivative
        return best, bestDerivateive

    def describeProblem(self, p):
        print()
        print("Objective function:")
        print(p[0])   # Expression
        print("Search space:")
        varNames = p[1][0] # p[1] is domain: [VarNames, low, up]
        low = p[1][1]
        up = p[1][2]
        for i in range(len(low)):
            print(" " + varNames[i] + ":", (low[i], up[i]))

    def displaySetting(self):
        print()
        print("Search algorithm: Gradient Descent")
        print()
        print("Mutation step size:", self.DELTA)

    def displayResult(self, solution, minimum):
        print()
        print("Solution found:")
        print(self.coordinate(solution))  # Convert list to tuple
        print("Minimum value: {0:,.3f}".format(minimum))
        print()
        print("Total number of evaluations: {0:,}".format(self.NumEval))

    def coordinate(self, solution):
        c = [round(value, 3) for value in solution]
        return tuple(c)  # Convert the list to a tuple
