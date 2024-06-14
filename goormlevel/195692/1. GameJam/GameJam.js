const readline = require("readline");
let rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});
let input = [];
rl.on("line", (line) => {
  input.push(line);
});

rl.on("close", () => {
  // 격자 보드의 크기
  const N = Number(input[0]);

  // 구름이 좌표 [1, 1]
  let gxy = input[1].split(" ").map((n) => Number(n) - 1);

  // 플레이어 좌표 [3, 3]
  let pxy = input[2].split(" ").map((n) => Number(n) - 1);

  // 보드
  const board = input.slice(3).map((b) => b.split(" "));

  // 각 점수를 구하는 함수
  const goormScore = playGame(N, board, gxy);
  const playerScore = playGame(N, board, pxy);

  console.log(
    goormScore > playerScore ? "goorm " + goormScore : "player " + playerScore
  );
});

// 게임 점수를 구하는 함수
function playGame(N, board, xy) {
  // 보드 크기와 같은 크기의 체크 배열 생성
  const check = Array.from({ length: N }, () => Array(N).fill(0));

  // 상 하 좌 우
  const command = {
    U: [-1, 0],
    D: [1, 0],
    R: [0, 1],
    L: [0, -1],
  };

  // 받아온 좌표
  let [x, y] = xy;

  // 게임을 종료시키는 플레그
  let flag = true;
  while (flag) {
    // 지시사항 분리
    // (N이 200까지라 200R의 경우 split으로 분리 불가)
    const len = board[x][y].length - 1;
    const cnt = Number(board[x][y].substring(0, len));
    const cmd = board[x][y].substring(len);

    // 위에 선언해 둔 이동할 좌표
    const [tx, ty] = command[cmd];

    // 구한 count만큼 for문을 통해 이동한다.
    for (let i = 0; i < cnt; i++) {
      // 이동하려는 장소가 이미 방문한 장소라면 종료
      if (check[x][y] === 1) {
        flag = false;
        break;
      }

      // 방문 체크
      check[x][y] = 1;

      // 이동
      x += tx;
      y += ty;

      // 칸이 넘어갔을 경우 반대 쪽으로 이동
      if (x < 0) x = N - 1;
      if (x === N) x = 0;
      if (y < 0) y = N - 1;
      if (y === N) y = 0;
    }
  }

  // 점수 구함
  return check.flat().filter((n) => n === 1).length;
}