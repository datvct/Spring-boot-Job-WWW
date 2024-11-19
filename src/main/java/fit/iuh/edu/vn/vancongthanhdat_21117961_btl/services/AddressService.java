package fit.iuh.edu.vn.vancongthanhdat_21117961_btl.services;

import fit.iuh.edu.vn.vancongthanhdat_21117961_btl.models.Address;
import fit.iuh.edu.vn.vancongthanhdat_21117961_btl.repositories.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {
    @Autowired
    private AddressRepository addressRepository;

    public List<Address> getAllAddresses() {
        return addressRepository.findAll();
    }

    public Address saveAddress(Address address) {
        return addressRepository.save(address);
    }
}
