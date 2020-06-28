:: redis 설치
- 인메모리 솔루션

- window 지원안함 . https://github.com/microsoftarchive/redis/releases/tag/win-3.2.100 에서 다운
- 기본포트는 6379

:: 지원 타입

String 		Text, 숫자 등 일반적인 Value
Set		Value가 Set 자료구조가 되므로, 하나의 Key 값에 여러 값을 Set 자료구조를 통해 저장 가능
Sorted Set	score라는 필드가 추가되어 정렬의 기준이 됨.
Hashes		Value가 Map 자료구조와 같은 Key/Value 형태가 됨
List		Value가 linkedList 자료구조가 됨. Push/Pop 연산 가능. index 활용 질의 가능


:: 스프링 제공

1. StringRedisTemplate of RedisTemplate	- 문자 특화된 템플릿
2. CrudRepository
