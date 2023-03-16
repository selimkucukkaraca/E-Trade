package com.example.etrade.config;

import com.example.etrade.model.BankAccount;
import com.example.etrade.repository.BankAccountRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

@Configuration
public class DataLoader implements CommandLineRunner {

    private final BankAccountRepository bankAccountRepository;

    @Value("${file.name}")
    private String FILE_NAME;

    public DataLoader(BankAccountRepository bankAccountRepository) {
        this.bankAccountRepository = bankAccountRepository;
    }

    @Override
    public void run(String... args) throws Exception {

       /*try(Scanner scanner = new Scanner(new BufferedReader(new FileReader(FILE_NAME)))) {

           while (scanner.hasNextLine()) {
               String[] line = scanner.nextLine().split(",");
               List<String> cvv = Collections.singletonList(line[3]);
               List<String> balance = Collections.singletonList(line[4]);

               for (String cvvValue: cvv) {
                   List<Integer> ccvInt = new ArrayList<>();
                   List<Double> balanceDouble = new ArrayList<>();
                   int cvvInt = Integer.parseInt(cvvValue);
                   ccvInt.add(cvvInt);

                   for (String balanceValue: balance) {
                       double balanceDoubleValue = Double.parseDouble(balanceValue);
                       balanceDouble.add(balanceDoubleValue);

                      for (int i =0; i < ccvInt.size(); i++) {
                          BankAccount bankAccount = new BankAccount(line[1], line[0], ccvInt.get(i), line[2], balanceDouble.get(i));
                          bankAccountRepository.save(bankAccount);
                      }
                   }
               }
           }
       }*/
    }
}