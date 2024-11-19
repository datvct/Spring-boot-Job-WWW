package fit.iuh.edu.vn.vancongthanhdat_21117961_btl;

import fit.iuh.edu.vn.vancongthanhdat_21117961_btl.models.Address;
import fit.iuh.edu.vn.vancongthanhdat_21117961_btl.repositories.AddressRepository;
import fit.iuh.edu.vn.vancongthanhdat_21117961_btl.repositories.CandidateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Random;

@SpringBootApplication
public class VanCongThanhDat21117961BtlApplication {

    public static void main(String[] args) {
        SpringApplication.run(VanCongThanhDat21117961BtlApplication.class, args);
    }

    @Autowired
    private CandidateRepository candidateRepository;
    @Autowired
    private AddressRepository addressRepository;

    CommandLineRunner initData(){
        return args -> {
//            Random rnd = new Random();
//            for(int i=1; i<1000;i++){
//                Address add = new Address(rnd.nextLong(1,1000) +"", "Quang Trung", "HCM", rnd
//                        .i);
//            }
        };
    }
}
