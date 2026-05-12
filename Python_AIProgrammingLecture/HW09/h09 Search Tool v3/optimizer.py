import math
import random
from setup import Setup
from problem import Problem
from problem import Numeric
from problem import Tsp


class HillClimbing(Setup):
    def __init__(self):
        super().__init__()
        self._problemType = 0
        self._fileName = ""
        self._algorithmType = 0
        self._LIMIT_STUCK = 100
        self._problem = None
        self._successor = []
        self._valueS = 0.0
        self.neighbors = []

    def main(self):
        self.run()
        selectedAlgorithm = None
        if self._problemType == 1:
            if self._algorithmType == 1:
                selectedAlgorithm = steepestAscent_n(self)
            elif self._algorithmType == 2:
                selectedAlgorithm = firstChoice_n(self)
            elif self._algorithmType == 3:
                selectedAlgorithm = gradientDescent(self)
        elif self._problemType == 2:
            if self._algorithmType == 1:
                 selectedAlgorithm = steepestAscent_tsp(self)
            elif self._algorithmType == 2:
                 selectedAlgorithm = firstChoice_tsp(self)

        if selectedAlgorithm != None:
            selectedAlgorithm.run()
        else:
            print("FAILED")
        
    def run(self):
        print("Select the problem type: ")
        print("1. Numerical Optimization")
        print("2. TSP")
        self._problemType = int(input("Enter the number: "))
        self._fileName = input("Enter the file name of a function: ")

        print("Select the search algorithm: ")
        print("1. Steepest-Ascent")
        print("2. Fisrt-Choice")
        if self._problemType == 1 :
            print("3. Gradient Descent")
        self._algorithmType = int(input("Enter the number: "))

    def setFields(self, baseSet):
        self._problemType = baseSet.getProblemType()
        self._fileName = baseSet.getFileName()
        self._algorithmType = baseSet.getAlgorithmType()

    def getProblemType(self):
        return self._problemType

    def getFileName(self):
        return self._fileName

    def getAlgorithmType(self):
        return self._algorithmType

    def getLIMITSTUCK(self):
        return self._LIMIT_STUCK

    def displaySetting(self):
        pass

    def algorithm(self):
        pass

    def bestOf(self):
        best = self._neighbors[0]
        bestValue = self._problem.evaluate(best)
        for i in range(1, len(self._neighbors)):
            newValue = self._problem.evaluate(self._neighbors[i])
            if newValue < bestValue:
                best = self._neighbors[i]
                bestValue = newValue
        return best, bestValue










class steepestAscent_n(HillClimbing):
    def __init__(self, baseSet):
        super().__init__()
        self.setFields(baseSet)
        
    def run(self):
        # Create a Problme object for numerical optimization
        self._problem = Numeric()    # Create a problem object 
        self._problem.setVariables(self.getFileName()) # Set its class variables (expression, domain)
        # Call the search algorithm
        self.algorithm()
        # Show the problem and algorithm settings
        self._problem.describe()
        self.displaySetting()
        # Report results
        self._problem.report()

    def algorithm(self):
        self._current = self._problem.randomInit() # 'current' is a list of values
        self._valueC = self._problem.evaluate(self._current)
        while True:
            self._neighbors = self._problem.mutants(self._current)
            (self._successor, self._valueS) = self.bestOf()
            if self._valueS >= self._valueC:
                break
            else:
                self._current = self._successor
                self._valueC = self._valueS
        self._problem.storeResult(self._current, self._valueC)
    
    def displaySetting(self):
        print()
        print("Search algorithm: Steepest-Ascent Hill Climbing")
        print()
        print("Mutation step size:", self._problem.getDelta())









class firstChoice_n(HillClimbing):
    def __init__(self, baseSet):
        super().__init__()
        self.setFields(baseSet)

    def run(self):
        # Create a Problme object for numerical optimization
        self._problem = Numeric()    # Create a problem object 
        self._problem.setVariables(self.getFileName()) # Set its class variables (expression, domain)
        # Call the search algorithm
        self.algorithm()
        # Show the problem and algorithm settings
        self._problem.describe()
        self.displaySetting()
        # Report results
        self._problem.report()
    
    def algorithm(self):
        self._current = self._problem.randomInit() # 'current' is a list of values
        self._valueC = self._problem.evaluate(self._current)
        i = 0
        while i < self._LIMIT_STUCK:
            self._successor = self._problem.randomMutant(self._current)
            self._valueS = self._problem.evaluate(self._successor)
            if self._valueS < self._valueC:
                self._current = self._successor
                self._valueC = self._valueS
                i = 0
            else:
                i += 1
        self._problem.storeResult(self._current, self._valueC)

    def displaySetting(self):
        print()
        print("Search algorithm: First-Choice Hill Climbing")
        print()
        print("Mutation step size:", self._problem.getDelta())
        print("Max evaluations with no improvement: {0:,} iterations"
          .format(self._LIMIT_STUCK))






    

class gradientDescent(HillClimbing):
    def __init__(self, baseSet):
        super().__init__()
        self.setFields(baseSet)  
        
    def run(self):
        # Create a Problme object for numerical optimization
        self._problem = Numeric()    # Create a problem object 
        self._problem.setVariables(self.getFileName()) # Set its class variables (expression, domain)
        # Call the search algorithm
        self.algorithm()
        # Show the problem and algorithm settings
        self._problem.describe()
        self.displaySetting()
        # Report results
        self._problem.report()

    def algorithm(self):
        self._current = self._problem.randomInit()  # Current point
        self._valueC = self._problem.evaluate(self._current)
        while True:
            self._successor = self._problem.takeStep(self._current, self._valueC)
            self._valueS = self._problem.evaluate(self._successor)
            if self._valueS >= self._valueC:
                break
            else:
                self._current = self._successor
                self._valueC = self._valueS
        self._problem.storeResult(self._current, self._valueC)

    def displaySetting(self):
        print()
        print("Search algorithm: Gradient Descent")
        print()
        print("Udate rate:", self._problem.getAlpha())
        print("Increment for calculating derivative:", self._problem.getDx())




        
class steepestAscent_tsp(HillClimbing):
    def __init__(self, baseSet):
        super().__init__()
        self.setFields(baseSet)

    def run(self):
        # Create an object for TSP
        self._problem = Tsp()        # Create a problem object 
        self._problem.setVariables(self.getFileName()) # Set its class variables (numCities, locations)
        # Call the search algorithm
        self.algorithm()
        # Show the problem and algorithm settings
        self._problem.describe()
        self.displaySetting()
        # Report results
        self._problem.report()

    def algorithm(self):
        self._current = self._problem.randomInit()   # 'current' is a list of city ids
        self._valueC = self._problem.evaluate(self._current)
        while True:
            self._neighbors = self._problem.mutants(self._current)
            (self._successor, self._valueS) = self.bestOf()
            if self._valueS >= self._valueC:
                break
            else:
                self._current = self._successor
                self._valueC = self._valueS
        self._problem.storeResult(self._current, self._valueC)

    def displaySetting(self):
        print()
        print("Search algorithm: Steepest-Ascent Hill Climbing")








class firstChoice_tsp(HillClimbing):
    def __init__(self, baseSet):
        super().__init__()
        self.setFields(baseSet)

    def run(self):
        # Create an object for TSP
        self._problem = Tsp()        # Create a problem object 
        self._problem.setVariables(self.getFileName()) # Set its class variables (numCities, locations)
        # Call the search algorithm
        self.firstChoiceAlgorithm()
        # Show the problem to be solved
        self._problem.describe()
        self.displaySetting()
        # Report results  
        self._problem.report()

    def firstChoiceAlgorithm(self):
        self._current = self._problem.randomInit() # Dictionary of {'var': value}
        self._valueC = self._problem.evaluate(self._current)
        i = 0
        while i < self._LIMIT_STUCK:
            self._successor = self._problem.randomMutant(self._current)
            self._valueS = self._problem.evaluate(self._successor)
            if self._valueS < self._valueC:
                self._current = self._successor
                self._valueC = self._valueS
                i = 0
            else:
                i += 1
        self._problem.storeResult(self._current, self._valueC)

    def displaySetting(self):
        print()
        print("Search algorithm: First-Choice Hill Climbing")
        print("Max evaluations with no improvement: {0:,} iterations"
              .format(self._LIMIT_STUCK))
        


HillClimbing().main()
