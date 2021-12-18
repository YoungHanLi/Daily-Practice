#include <stdio.h>
#include <stdlib.h>

/*링크리스트 정의*/
typedef struct Intlinked
{
  int num;
  struct Intlinked * next;
}IntLinked;

/*함수 프로토타입*/
int InputLenth(void);
void add(IntLinked*, int);

/*---------------------------메인함수---------------------------*/
int main(void)
{
  int len_list=0; // 사용자가 몇개의 노드를 구성할건지 저장
  int i=0; //반복문의 반복조건으로 사용
  int input_num=0; // 사용자가 노드하나에 저장할 값의 임시저장공간

/*링크리스트의 시작인 헤드*/
  IntLinked* head;
  head=(IntLinked*)malloc(sizeof(IntLinked));
  head->next=NULL;
/* 사용자로부터 링크리스트를 몇개의 노드로 구성할건지 입력받는다 */
  len_list=InputLenth();

/* 링크리스트 맨뒤에 노드를 하나씩 추가 */
  for(i=0;i<len_list;i++)
  {
    printf("정수를 입력하세요 : ");
    scanf("%d",&input_num);
    add(head,input_num);
  }

/*Print*/
  IntLinked* print=head->next;
  for(i=0;i<len_list;i++)
  {
    printf("저장된 정수: %d\n",print->num);
    print=print->next;
  }
  
  free(head);

  return 0;
}
/*---------------------------메인함수 끝---------------------------*/

/* 사용자로부터 링크리스트의 노드를 몇개로 만들건지 입력받는 함수 */
int InputLenth(void)
{
  int lenth=0;
  printf("생성할 리스트의 개수 입력: ");
  scanf("%d",&lenth);
  return lenth;
}

/*연결리스트 맨끝에 노드하나 추가해주는 함수*/
void add(IntLinked* list, int input_num)
{
  if(list->next==NULL) // 헤드를 제외하고 노드가 1개도 존재하지 않는 경우
  {
    IntLinked* newNode = (IntLinked*)malloc(sizeof(IntLinked));
    newNode->num=input_num;
    newNode->next=NULL;
    list->next=newNode;
  }
  else // 노드가 1개 이상 존재하는 경우
  {
    IntLinked* temp = list;
    while(temp->next != NULL)
    {
      temp= temp->next;
    }
    IntLinked* newNode=malloc(sizeof(IntLinked));
    newNode->num=input_num;
    newNode->next=NULL;
    temp->next=newNode;
  }
}
