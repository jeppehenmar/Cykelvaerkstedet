package controllers;

import dao.DatabaseReader;
import dao.DatabaseWriter;
import dao.interfaces.ReadInterface;
import dao.interfaces.WriteInterface;

/**
 * Created by leonemborg on 20/11/2017.
 */
public class DatabaseController {
    ReadInterface reader = new DatabaseReader();
    WriteInterface writer = new DatabaseWriter();

}

