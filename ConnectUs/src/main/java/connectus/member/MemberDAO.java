package connectus.member;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface MemberDAO {
	
	public List<MemberDTO> getList();
	
	public List<MemberDTO> oneMember(String userid);
	
	public List<MemberDTO> oneMember_phone(String phone);
	
	public int insertMember(MemberDTO dto);
		
}
