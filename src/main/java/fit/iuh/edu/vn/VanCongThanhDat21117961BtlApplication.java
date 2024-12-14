package fit.iuh.edu.vn;

import com.neovisionaries.i18n.CountryCode;
import fit.iuh.edu.vn.backend.models.Address;
import fit.iuh.edu.vn.backend.models.Candidate;
import fit.iuh.edu.vn.backend.repositories.AddressRepository;
import fit.iuh.edu.vn.backend.repositories.CandidateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
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

//    @Bean
//    CommandLineRunner initData(){
//        return args -> {
//            Random rnd = new Random();
//            for(int i =1; i<1000;i++){
//                Address add = new Address(rnd.nextInt(1,1000)+"", "Quang trung","HCM",rnd.nextInt(7000,80000)+"", CountryCode.VN );
//                addressRepository.save(add);
//
//                Candidate can = new Candidate("Name #" + i, LocalDate.of(2003,rnd.nextInt(1,12), rnd.nextInt(1,29)), add,rnd.nextLong(1111111111L,9999999999L )+"","email_"+i+"@gmail.com");
//                candidateRepository.save(can);
//                System.out.println("added: "+can);
//            }
//        };
//    }
}
