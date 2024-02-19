
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import java.lang.reflect.Member;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.data.repository.CrudRepository;
import com.greenfieldlibrary.backend.controllers.MembersController;
import com.greenfieldlibrary.backend.persistence.MembersRepository;

@SpringBootTest
public class MembersControllerTest {

    @Mock
    private MembersRepository memberRepository;

    @InjectMocks
    private MembersController membersController;

    @BeforeEach
    public void setUp() {
        Member expectedMember = new Member(1, "Test Name", "Test LastName", "Test Phone", "Test Email");
        when(memberRepository.findById(1)).thenReturn(Optional.of(expectedMember));
    }

    @Test
    public void testGetMemberByIdReturnsCorrectMember() throws Exception {

        ResponseEntity<Member> response = membersController.getMemberById(1);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        Member actualMember = response.getBody();
        assertEquals(1, actualMember.getId());
        assertEquals("Test Name", actualMember.getName());
        assertEquals("Test LastName", actualMember.getLastName());
        assertEquals("Test Phone", actualMember.getPhone());
        assertEquals("Test Email", actualMember.getEmail());
    }

    @Test
    public void testCreateMemberCreatesMemberAndReturnsCorrectResponse() throws Exception {
        Member newMember = new Member(1, "New Test Name", "New Test LastName", "New Test Phone", "New Test Email");
        when(memberRepository.save(newMember)).thenReturn(newMember);

        ResponseEntity<Member> response = membersController.createMember(newMember);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        Member actualMember = response.getBody();
        assertEquals(newMember.getId(), actualMember.getId());
        assertEquals(newMember.getName(), actualMember.getName());
        assertEquals(newMember.getLastName(), actualMember.getLastName());
        assertEquals(newMember.getPhone(), actualMember.getPhone());
        assertEquals(newMember.getEmail(), actualMember.getEmail());
    }
}