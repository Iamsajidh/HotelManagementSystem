package com.hms.hussain.StaffMicroservice;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class StaffMicroserviceApplicationTests {

	@Test
	void contextLoads() {
	}

}





/*
 * package com.RrsCaseStudy;
 * 
 * 
 * 
 * import org.junit.jupiter.api.Test ;
 * 
 * 
 * 
 * import org.springframework.boot.test.context.SpringBootTest;
 * 
 * 
 * 
 * import org.junit.jupiter.api.Test; import org.junit.runner.RunWith; import
 * org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.boot.test.context.SpringBootTest; import
 * org.springframework.boot.test.mock.mockito.MockBean; import
 * org.springframework.test.context.junit4.SpringRunner;
 * 
 * 
 * 
 * import com.RrsCaseStudy.Repository.RrsRepository; import
 * com.RrsCaseStudy.Resource.TrainAvailabilityResource; import
 * com.RrsCaseStudy.model.TrainAvailability;
 * 
 * 
 * 
 * import static org.junit.Assert.assertEquals; import static
 * org.mockito.Mockito.times; import static org.mockito.Mockito.verify; import
 * static org.mockito.Mockito.when;
 * 
 * 
 * 
 * import java.util.stream.Collectors; import java.util.stream.Stream;
 * 
 * @RunWith(SpringRunner.class)
 * 
 * @SpringBootTest class TrainAvailabilityApplicationTests {
 * 
 * @Autowired TrainAvailabilityResource service;
 * 
 * @MockBean RrsRepository repository;
 * 
 * @Test public void getTrainTest() {
 * when(repository.findAll()).thenReturn(Stream .of(new
 * TrainAvailability(12,"Tapan","Banglore","Delhi",8346.23d,null), new
 * TrainAvailability(12,"Tapan","Banglore","Delhi",8346.23d,null))
 * .collect(Collectors.toList())); assertEquals(2,service.getTrains().size()); }
 * 
 * @Test public void getTrainBySource() { String source = "Bangalore";
 * when(repository.findByStartLocation(source)).thenReturn(Stream .of(new
 * TrainAvailability(12,"Tapan","Banglore","Delhi",8346.23d,null))
 * .collect(Collectors.toList()));
 * assertEquals(1,service.getTrainByStartLocation(source).size()); }
 * 
 * @Test public void getTrainByDestination() { String destination = "Delhi";
 * when(repository.findByStartLocation(destination)).thenReturn(Stream .of(new
 * TrainAvailability(12,"Tapan","Banglore","Delhi",8346.23d,null))
 * .collect(Collectors.toList()));
 * assertEquals(1,service.getTrainByStartLocation(destination).size()); }
 * 
 * @Test public void addTrainTest() { TrainAvailability train= new
 * TrainAvailability(12,"Tapan","Banglore","Delhi",8346.23d,null);
 * when(repository.save(train)).thenReturn(train);
 * assertEquals(train,service.AddTrain(train)); }
 * 
 * @Test public void updateTrainTest() { TrainAvailability train= new
 * TrainAvailability(12,"Tapan","Banglore","Delhi",8346.23d,null);
 * when(repository.save(train)).thenReturn(train);
 * assertEquals(train,service.UpdateTrain(train));
 * 
 * }
 * 
 * @Test public void deleteTrainTest() { TrainAvailability train = new
 * TrainAvailability(12,"Tapan","Banglore","Delhi",8346.23d,null);
 * service.deleteTrain(train); verify(repository,times(1)).delete(train);
 * 
 * } }
 */


