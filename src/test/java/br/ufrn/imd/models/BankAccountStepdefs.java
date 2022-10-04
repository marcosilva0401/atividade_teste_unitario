package br.ufrn.imd.models;

import br.ufrn.imd.models.BankAccount;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class BankAccountStepdefs {

        private BankAccount bankAccount;
        private BankAccount bankAccountDestino;

        @Given("um BankAccount com saldo de R$ {double}")
        public void um_bank_account_com_saldo_de_r$(Double double1) {
            //TODO
            bankAccount = new BankAccount(123456, 123, double1);
        }

        @When("depositar R$ {double}")
        public void depositar_r$(Double double1) {
            //TODO
            bankAccount.deposit(double1);
        }

        @Then("o saldo do BankAccount deve ser R$ {double}")
        public void o_saldo_deve_ser_r$(Double double1) {
            //TODO
            var saldo = bankAccount.getBalance();
            assertEquals(double1, saldo);
        }

        @When("retirar R$ {double}")
        public void retirar_$(Double double1){
            bankAccount.withdraw(double1);
        }

        @And("um BankAccount de destino com saldo de R$ {double}")
        public void um_bank_account_de_destino_com_saldo_de_r$(Double double1){
            bankAccountDestino = new BankAccount(2022515, 90485, double1);
        }

        @When("tranferir R$ {double} para o BankAccount de destino")
        public void transferir_$(Double double1){
            bankAccount.transfer(bankAccountDestino, double1);
        }
        @And("o saldo do BankAccount de destino deve ser R$ {double}")
        public void o_saldo_do_destino_deve_ser_r$(Double double1) {
            //TODO
            var saldo = bankAccountDestino.getBalance();
            assertEquals(double1, saldo);
        }


    }
