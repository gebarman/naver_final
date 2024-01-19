package board.spring.mybatis;


import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface MemberDAO {

	public MemberDTO oneMember(String memberid); //member-mapping에 있는 oneMember sql과 같은 이름으로

}
