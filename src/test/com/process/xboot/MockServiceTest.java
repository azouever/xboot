package com.process.xboot;

import com.process.xboot.controller.BillController;
import com.process.xboot.service.BillService;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/**
 * @author Kai
 */

//@SpringBootTest(webEnvironment = WebEnvironment.NONE,classes = {BillController.class,
//    BillServiceImpl.class})
//@RunWith(MockitoJUnitRunner.class)
//@RunWith(SpringJUnit4ClassRunner.class)
@ExtendWith(SpringExtension.class)
public class MockServiceTest {

  //  @Autowired
  @InjectMocks
  private BillController billController;

  //  @MockBean
  @Mock
  private BillService billService;

  @BeforeEach
  public void beforeExecute() {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  public void testGet() {
    Mockito.when(billService.pay(Mockito.any(String.class))).thenReturn("success");
    String result = billService.pay("213");
    billService.pay("213");
    Assert.assertNotNull(result);
    Mockito.verify(billService, Mockito.timeout(1000).times(2)).pay("213");

  }
}
