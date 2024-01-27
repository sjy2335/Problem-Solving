#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>
#include <string.h>

// id_list_len은 배열 id_list의 길이입니다.
// report_len은 배열 report의 길이입니다.
// 파라미터로 주어지는 문자열은 const로 주어집니다. 변경하려면 문자열을 복사해서 사용하세요.
int* solution(const char* id_list[], size_t id_list_len, const char* report[], size_t report_len, int k) {
    // return 값은 malloc 등 동적 할당을 사용해주세요. 할당 길이는 상황에 맞게 변경해주세요.
    int* reported = (int*)calloc(id_list_len, sizeof(int));
    int* answer = (int*)calloc(id_list_len, sizeof(int));

    // 1. 정지되는 사람
    for (int i = 0; i < report_len; i++) {
        char* ptr = strtok(report[i], " ");
        ptr = strtok(NULL, " "); //신고 받은 사람
        for (int i = 0; i < id_list_len; i++) {
            if (!strcmp(ptr, id_list[i])) {
                reported[i]++;
            }
        }
    }
    for (int i = 0; i < id_list_len; i++) {
        printf("%d", reported[i]);
    }
    printf("\n");

    // 2. 결과 메일 수 처리
    // 2-1. reported가 k 이상이면
    for (int i = 0; i < id_list_len; i++) {
        if (reported[i] >= k) {
            // 2-2. id_list에서 그 사람을 report했으면 answer 값 늘림.
            for (int j = 0; j < report_len; j++) {
                char tmp[4][11] = { {0,}, };
                char* ptr = strtok(report[j], " ");
                int m = 0;
                while (ptr != NULL)
                {
                    strcpy(tmp[m], ptr); //cut[i] = ptr는 안됨(배열이름이 포인터라서)
                    ptr = strtok(NULL, " ");
                    m++;
                }
                for (int l = 0; l < 2; l++)printf("\n%s", tmp[l]);
                for (int k = 0; k < id_list_len; k++) {
                    if ((!strcmp(tmp[0], id_list[k])) && (!strcmp(tmp[1], id_list[i]))) answer[k]++;
                }
            }
        }
    }

    return answer;
}