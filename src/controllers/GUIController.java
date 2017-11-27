package controllers;

import models.Constants;

import java.util.List;

/**
 * Created by jeppe on 20-11-2017.
 */
public class GUIController {
    public List getProductList() {
        return Constants.fillProductList();
    }
}
