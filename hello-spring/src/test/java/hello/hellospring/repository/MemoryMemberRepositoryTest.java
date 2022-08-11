package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository(); // 메모리 상에 위치할 db 저장소

    @AfterEach // 각각의 테스트가 실행되고 끝날 때마다 이 메소드가 실행됨: 콜백
    public void afterEach() {
        repository.clearStore();
    }

    @Test
    public void save(){
        // 저장이 잘 되는지 확인하는 코드 // main 메소드에서 작성하는 것처럼 작성하면 됨.
        Member member = new Member();
        member.setName("spring");

        repository.save(member); // respository에 저장함.

        // repository에 저장된 것과 일치하는지 확인하는 코드
        Member result = repository.findById(member.getId()).get();

//        System.out.println("member = " + (member == result)); // true로 뜨면 일치!

//        Assertions.assertEquals(member, result); // 아무것도 안뜨면 일치!
//        Assertions.assertEquals(member, null); // 에러

        assertThat(member).isEqualTo(result);
    }

    @Test
    public void findByName(){
         // findByName() 가 잘 되는지 확인하는 테스트 코드 를 작성할 main 메소드

        Member member1 = new Member();
        member1.setName("Spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("Spring2");
        repository.save(member2);

        Member result = repository.findByName("Spring1").get();

        assertThat(result).isEqualTo(member1);


    }

    @Test
    public void findAll() {
          Member member1 =  new Member();
          member1.setName("Spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("Spring2");
        repository.save(member2);

        List<Member> result = repository.findAll();

        assertThat(result.size()).isEqualTo(2);

    }
}
