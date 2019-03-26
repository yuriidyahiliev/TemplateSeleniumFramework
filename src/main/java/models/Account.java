package models;

import core.annotations.Source;
import lombok.Data;

@Data
@Source(source = "accountAmazon.json")
public class Account {

    private final String username;
    private final String password;
}
