package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member); // 회원이 저장소에 저장하는 기능

    Optional<Member> findById(Long id);     // 회원을 id로 찾는 기능 (id가 없으면, null 을 반환하기 때문에 Optional<>)
    Optional<Member> findByName(String name);   // 회원을 name으로 찾는 기능

    List<Member> findAll(); // 지금까지 저장된 회원 리스트 반환하는 기능.


}
