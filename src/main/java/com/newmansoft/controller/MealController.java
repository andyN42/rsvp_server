package com.newmansoft.controller;


import com.newmansoft.model.MealChoice;
import com.newmansoft.service.MealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//        import com.concretepage.component.IPersonService;
@RestController
@RequestMapping("/meal")
public class MealController {


    @Autowired
    private MealService mealService;

    public MealController() {

    }

    @RequestMapping("/{id}")
    public ResponseEntity<MealChoice> getMeal(@PathVariable String id) {

        return new ResponseEntity<MealChoice>(HttpStatus.NOT_IMPLEMENTED);

    }
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<List<MealChoice>> getAllMeals() {

        List<MealChoice> mealChoices = mealService.findAll();

        return new ResponseEntity<List<MealChoice>>(mealChoices, HttpStatus.OK);


    }
}