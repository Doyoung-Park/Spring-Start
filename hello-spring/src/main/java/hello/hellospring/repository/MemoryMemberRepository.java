package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.*;


public class MemoryMemberRepository implements MemberRepository{

    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L; // key 값을 생성해주는 것.
    // 실무에서는 동시성 문제를 고려해야 함


    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member); // store 에 (map) 저장함.

        return member;

    }

    @Override
    public Optional<Member> findById(Long id) {

        return Optional.ofNullable(store.get(id));      // Null 이 반환될 수도 있는 경우에는 Optional.ofNullable()로 값을 감싸서 리턴함
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()      // 람다 사용됨
                .filter(member -> member.getName().equals(name)) // 매개변수로 넘어온 name 과 저장되어 있는 name과 일치하는 지를 확인함.
                .findAny();
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());      // store에 저장된 멤버들을 리스트의 형태로 리턴해줌.
    }
    // map 에 저장된 데이터들을 리스트로 반환해줌.

    public void clearStore(){
        store.clear(); // store 를 싹 비운다.
    }

}


