// 변수
let a = 3;
let b = 2;
console.log(a + b);
b = 7;
console.log(a + b);

// 홑/쌍따옴표 상관 없음
let name = '소은';
let course = "웹개발의 봄 Spring";
let num = 10;
console.log(num + name);    // 문자 + 숫자 -> 문자 더하기

let age1 = 18;
let age2 = 20;
let isAdult = age1 > 19;
console.log(isAdult);   // false
isAdult = age2 > 19;
console.log(isAdult);   // true

// 리스트
let fruits = ['사과', '딸기', '수박'];
console.log(fruits[0]);
console.log(fruits[1]);
console.log(fruits[2]);

// 딕셔너리
let course2 = {
    'title': '웹개발의 봄, Spring',
    'tutor': '남병관'
};
console.log(course2);

// 반복문
for (let i = 0; i < fruits.length; i++) {
    let fruit = fruits[i];
    console.log(fruit);
}

// 조건문
for (let i = 0; i < fruits.length; i++) {
    let fruit = fruits[i];
    console.log(fruit == '수박')
}

// 함수
function sample() {
    alert('얼럿!');
}

// 백틱
let name2 = '김소은';
let text = `${name2}님의 스프링 5주 완주를 축하합니다!`;
console.log(text);

// 연습퀴즈 - 과일 개수 세기
function countFruit(name) {
    let fruits = ['사과', '딸기', '수박', '감', '배', '딸기', '감'];

    let count = 0;
    for (let i = 0; i < fruits.length; i++) {
        let fruit = fruits[i];
        if (fruit == name) count++;
    }
    return count;
}
let count = countFruit('감');
console.log(count);
