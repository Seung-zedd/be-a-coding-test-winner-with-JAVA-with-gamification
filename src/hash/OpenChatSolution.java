package hash;

import java.util.*;

/*
[문제 해석]
카카오톡 오픈채팅방에서는 친구가 아닌 사람들과 대화를 할 수 있는데, 본래 닉네임이 아닌 "가상의 닉네임을 사용"하여 채팅방에 들어갈 수 있다.
-> // nickname도 record에 준다.

채팅방에서 닉네임을 변경하는 방법은 다음과 같이 두 가지이다.
    채팅방을 나간 후, 새로운 닉네임으로 다시 들어간다.
    //-> if isOut: 닉네임 업데이트
    채팅방에서 닉네임을 변경한다.
    -> -> Leave는 무시하고, Enter나 Change의 닉네임만 put()으로 계속 업데이트

닉네임을 변경할 때는 기존에 채팅방에 출력되어 있던 메시지의 닉네임도 전부 변경된다.
//-> 채팅방의 기존의 닉네임을 기억하기 위한 자료구조가 필요
-> 위의 put()과 중복되는 내용

채팅방은 중복 닉네임을 허용하기 때문에, 현재 채팅방에는 Prodo라는 닉네임을 사용하는 사람이 두 명이 있다. 
-> 고유의 ID를 부여할 필요가 있음
-> 아래의 제한사항에서 "모든 유저는 [유저 아이디]로 구분한다."가 있으므로 ID -> 유저 아이디로 매핑

요구사항: 모든 기록이 처리된 후
-> record를 for문으로 순회 한 후

**최종적으로 방을 개설한 사람이 보게 되는 메시지**를 문자열 배열 형태로 return
//-> 내가 보기엔, **해시맵**에 있는 닉네임을 파싱해서 문자열 배열 형태로 리턴하라고 하는 것 같음.
//-> Map<userId, nickname>
-> //? "최종적으로"가 해시맵의 닉네임을 계속해서 업데이트하라는 단서였나?

- 제한사항 - 
1. record는 다음과 같은 문자열이 담긴 배열이며, 길이는 1 이상 10^5 이하이다.
-> //! 하나의 for문만 사용하라는 의미!

2. 모든 유저는 [유저 아이디]로 구분한다.
-> key로 구분(그래서 중복 닉네임도 인정한다는 의미, 왜냐하면 유저 아이디가 uniqueness를 충족하기 때문)

3. [유저 아이디] 사용자가 [닉네임]으로 채팅방에 입장 - "Enter [유저 아이디] [닉네임]" (ex. "Enter uid1234 Muzi")
-> Enter [getKey] [getValue]

4. [유저 아이디] 사용자가 채팅방에서 퇴장 - "Leave [유저 아이디]" (ex. "Leave uid1234")
-> Leave [getKey]
-> //! 아... 이 단서가 표 편집과 비슷하게 ArrayIndexOutOfBoundsException의 단서였음! -> for문에서 파싱하는게 아니라 switch-case문에서 파싱하라는 의미

5. [유저 아이디] 사용자가 닉네임을 [닉네임]으로 변경 - "Change [유저 아이디] [닉네임]" (ex. "Change uid1234 Muzi")
-> 7번 해석한 의미와 동일

6. 첫 단어는 Enter, Leave, Change 중 하나이다.
-> 이전에 풀었던 표 편집 문제처럼 첫 단어를 command로 파싱할 필요가 있음

7. 각 단어는 공백으로 구분되어 있으며, 알파벳 대문자, 소문자, 숫자로만 이루어져있다.
-> 공백으로 구분되어 있다 == split()을 사용하라는 의미?

8. 유저 아이디와 닉네임은 알파벳 대문자, 소문자를 구별한다.
-> <K, V>는 대소문자를 구별, 즉 unique는 보장됨

9. 유저 아이디와 닉네임의 길이는 1 이상 10 이하이다.

10. 채팅방에서 나간 유저가 닉네임을 변경하는 등 잘못 된 입력은 주어지지 않는다.
//-> 처음에는 채팅방에 있기 때문에 isOut을 "false"로 초기화하자. 즉, <K, String[]>으로 제네릭해서 idx 0은 닉네임을, idx 1은 나갔는지의 여부를 설정
-> Leave의 닉네임은 신경쓰지 마라~

*/

public class OpenChatSolution {
    public String[] solution(String[] record) {
        // 1. 최종 닉네임을 반영하기 위해 해시맵에 저장
        Map<String, String> userMap = new HashMap<>();

        // 1-pass: 최종 닉네임만 추적
        for (int i = 0; i < record.length; i++) {
            String[] msg = record[i].split(" ");

            // 닉네임이 있을 때만 해시맵에 저장
            if (msg.length > 2) {
                String userid = msg[1];
                String nickname = msg[2];

                userMap.put(userid, nickname);
            }
        }

        // 2-pass: record의 파라미터를 추출해서 메시지와 조립
        List<String> answer = new ArrayList<>();
        for (int i = 0; i < record.length; i++) {
            String[] msg = record[i].split(" ");
            String command = msg[0];
            String userid = msg[1];

            switch (command) {
                case "Enter":
                    answer.add(userMap.get(userid) + "님이 들어왔습니다.");
                    break;
                case "Leave":
                    answer.add(userMap.get(userid) + "님이 나갔습니다.");
                    break;
            }
        }

        return answer.stream().toArray(String[]::new);
    }
}
