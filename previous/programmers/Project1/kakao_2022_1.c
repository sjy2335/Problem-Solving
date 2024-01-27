#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>
#include <string.h>

// id_list_len�� �迭 id_list�� �����Դϴ�.
// report_len�� �迭 report�� �����Դϴ�.
// �Ķ���ͷ� �־����� ���ڿ��� const�� �־����ϴ�. �����Ϸ��� ���ڿ��� �����ؼ� ����ϼ���.
int* solution(const char* id_list[], size_t id_list_len, const char* report[], size_t report_len, int k) {
    // return ���� malloc �� ���� �Ҵ��� ������ּ���. �Ҵ� ���̴� ��Ȳ�� �°� �������ּ���.
    int* reported = (int*)calloc(id_list_len, sizeof(int));
    int* answer = (int*)calloc(id_list_len, sizeof(int));

    // 1. �����Ǵ� ���
    for (int i = 0; i < report_len; i++) {
        char* ptr = strtok(report[i], " ");
        ptr = strtok(NULL, " "); //�Ű� ���� ���
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

    // 2. ��� ���� �� ó��
    // 2-1. reported�� k �̻��̸�
    for (int i = 0; i < id_list_len; i++) {
        if (reported[i] >= k) {
            // 2-2. id_list���� �� ����� report������ answer �� �ø�.
            for (int j = 0; j < report_len; j++) {
                char tmp[4][11] = { {0,}, };
                char* ptr = strtok(report[j], " ");
                int m = 0;
                while (ptr != NULL)
                {
                    strcpy(tmp[m], ptr); //cut[i] = ptr�� �ȵ�(�迭�̸��� �����Ͷ�)
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