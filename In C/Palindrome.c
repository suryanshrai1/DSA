

#include <stdio.h>
#include<string.h>

int main(){
  char str[101];
  int len, IsPalindrome =1;
  scanf("%s", str);
  
  len = strlen(str);
  
  for(int i =0; i<len/2; i++){
    if(str[i] != str[len-i-1]){
      IsPalindrome = 0;
      break;
    }
  }
  
  if(IsPalindrome){
    printf("Yes\n");
  }
  else{
    printf("No\n");
  }
}