package lt.vilniustech.karolisRut.pirmas_darbas.model;

import jakarta.persistence.*;

@Entity
@Table(name = "account")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, unique = true)
    private String accountNumber;

    @Column(nullable = false)
    private String accountName;

    @Column(nullable = false)
    private float amount;

    public Account() {}

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getAccountNumber() { return accountNumber; }
    public void setAccountNumber(String accountNumber) { this.accountNumber = accountNumber; }

    public String getAccountName() { return accountName; }
    public void setAccountName(String accountName) { this.accountName = accountName; }

    public float getAmount() { return amount; }
    public void setAmount(float amount) { this.amount = amount; }
}
