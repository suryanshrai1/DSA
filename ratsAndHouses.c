#include<stdio.h>

int rat(int*arr, int noh, int r, int unit){
    int result;
    result= r*noh;
    int i;
    int sum=0;
    for(i=0; i<noh; i++){
        sum= sum+ arr[i];
        if(result<= sum){
            return i+1;
        }
    }
}
int main(){
    int houses[9]= {2,8,3,5,7,9,1,15};
    int houses;
}