#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define ROW 1001
#define COL 1001

int matrix[ROW][COL];
int visited[ROW] = { 0 };

int stack_top = -1;
int stack_size = ROW;
int stack[ROW];

int front = 0;
int rear = 0;
int queue[ROW];

int size_stack() {
    if (stack_top <= 0)
        return 0;
    else
        return stack_top + 1;
}

int empty_stack() {
    if (stack_top == -1)
        return 1;
    else
        return 0;
}

int full_stack() {
    if (stack_top == stack_size - 1)
        return 1;
    else
        return 0;
}

void push_stack(int item) {
    if (full_stack()) {
        return;
    }
    else {
        *(stack + ++stack_top) = item;
    }
}

int pop_stack() {
    if (empty_stack()) {
        return 0;
    }
    else {
        return *(stack + stack_top--);
    }
}

int top_stack() {
    if (empty_stack()) {
        return 0;
    }
    else {
        return *(stack + stack_top);
    }
}

void dfs(int start, int max) {

    int v = start, w, changed = 0, i;
    visited[v] = 1;
    printf("%d ", v);
    do {
        changed = 0;
        //finding adjacent vertex
        for (i = 1; i <= max; i++) {
            if (matrix[v][i] && !visited[i]) {
                w = i;
                break;   
            }
        }
        if (visited[w] == 0) {
            push_stack(v);
            visited[w] = 1;
            printf("%d ", w);
            v = w;
            changed = 1;
        }
        else {
            v = pop_stack();
        }
    } while (!empty_stack());
}

int empty_queue() {
    if (front == rear) {
        return 1;
    }
    else
        return 0;
}

int full_queue() {
    if (((rear + 1) % ROW) == front) {
        return 1;
    }
    else
        return 0;
}

void push_queue(int item) {
    if (full_queue())
        return;
    else {
        rear = (rear + 1) % ROW;
        queue[rear] = item;
    }
}

int pop_queue() {
    if (empty_queue()) {
        return -1;
    }
    else {
        front = (front + 1) % ROW;
        return queue[front];
    }
}

int front_queue() {
    if (empty_queue()) {
        return -1;
    }

    else
        return queue[(front + 1) % ROW];
}

void bfs(int start, int max) {
    int v = start, w = 0, i = 0;
    visited[v] = 1;
    printf("%d ", v);
    do {
        //finding adjacent vertex
        for (i = 1; i <= max; i++) {
            if (matrix[v][i] && !visited[i]) {
                w = i;
                if (!visited[w]) {
                    visited[w] = 1;
                    printf("%d ", w);
                    push_queue(w);
                }
            }
        }
        v = pop_queue();
    } while (!empty_queue());

}

int main(void) {
    int i, N, M, V, first, second;
    int j = 0;

    scanf("%d %d %d", &N, &M, &V);

    for (i = 0; i < M; i++) {
        scanf("%d %d", &first, &second);
        matrix[first][second] = 1;
        matrix[second][first] = 1;
    }

    dfs(V, N);
    for (i = 0; i < ROW; i++) visited[i] = 0;
    printf("\n");
    bfs(V, N);
    return 0;
}