package com.hussain.hms.GuestMicroservice;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.hussain.hms.GuestMicroservice.Models.Guest;
import com.hussain.hms.GuestMicroservice.Repository.GuestRepository;
import com.hussain.hms.GuestMicroservice.Service.Guestservice;
import com.hussain.hms.GuestMicroservice.Service.GuestserviceImpl;

@SpringBootTest
class GuestMicroserviceApplicationTests {

	@Mock
	private GuestRepository repo;

	@InjectMocks
	private GuestserviceImpl service;

	@Test
	void contextLoads() {
	}

	@Test
	public void getAllGuestTest() {
		when(repo.findAll())
				.thenReturn(Stream
						.of(new Guest(1, "abc", 998877665, "abc@gmail.com", "Male", "us"),
								new Guest(2, "def", 112233445, "def@gmail.com", "Female", "uk"))
						.collect(Collectors.toList()));

		List<Guest> guests = service.getAllGuest();

		assertEquals(2, guests.size());
		assertEquals("abc", guests.get(0).getGuestName());
		assertEquals("def", guests.get(1).getGuestName());
	}

	@Test
	public void addGuestTest() {
		Guest guest = new Guest(1, "abc", 998877665, "abc@gmail.com", "Male", "us");

		when(repo.insert(guest)).thenReturn(guest);

		Guest addedGuest = service.addGuest(guest);

		assertEquals(guest, addedGuest);
	}

	@Test
	public void updateGuestTest() {
		Guest guest = new Guest(1, "abc", 998877665, "abc@gmail.com", "Male", "us");

		when(repo.save(guest)).thenReturn(guest);

		Guest updatedGuest = service.updateGuest(guest);

		assertEquals(guest, updatedGuest);
	}

	@Test
	public void deleteGuestTest() {
		Guest guest = new Guest(1, "abc", 998877665, "abc@gmail.com", "Male", "us");

		service.deleteGuest(guest.getGuestId());

		verify(repo, times(1)).deleteById(guest.getGuestId());
	}

	@Test
	public void getGuestTest() {
		Guest guest = new Guest(1, "abc", 998877665, "abc@gmail.com", "Male", "us");

		when(repo.findById(1)).thenReturn(Optional.of(guest));

		Optional<Guest> retrievedGuest = service.getGuest(1);

		assertEquals(guest, retrievedGuest.orElse(null));
	}
}
