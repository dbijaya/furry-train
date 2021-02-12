package com.bijay.springbootjpa.tutorial;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class TutorialController {

    @Autowired
    TutorialRepository tutorialRepository;

    private Sort.Direction getSortDirection(String direction) {
        if (direction.equals("asc")) {
            return Sort.Direction.ASC;
        } else if (direction.equals("desc")) {
            return Sort.Direction.DESC;
        }
        return Sort.Direction.ASC;
    }

    @GetMapping("/tutorials")
    public ResponseEntity<Map<String, Object>> getAllTutorials(@RequestParam(required = false) String title,
                                                               @RequestParam(defaultValue = "0") int page,
                                                               @RequestParam(defaultValue = "3") int size) {
        try {
            List<Tutorial> tutorials = new ArrayList<Tutorial>();
            Pageable pageable = PageRequest.of(page, size);

            Page<Tutorial> tutorialPage;
            if (title == null) {
                tutorialPage = tutorialRepository.findAll(pageable);
            } else {
                tutorialPage = tutorialRepository.findByTitleContaining(title, pageable);
            }

            Map<String, Object> response = new HashMap<>();

            tutorials = tutorialPage.getContent();

            response.put("tutorials", tutorials);
            response.put("currentPage", tutorialPage.getNumber());
            response.put("totalItems", tutorialPage.getTotalElements());
            response.put("totalPages", tutorialPage.getTotalPages());

            return new ResponseEntity<>(response, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/tutorials/published")
    public ResponseEntity<Map<String, Object>> findByPublished(@RequestParam(defaultValue = "0") int page,
                                                               @RequestParam(defaultValue = "3") int size) {
        try {
            List<Tutorial> tutorials = new ArrayList<Tutorial>();
            Pageable pageable = PageRequest.of(page, size);

            Page<Tutorial> tutorialPage = tutorialRepository.findByPublished(true, pageable);

            Map<String, Object> map = new HashMap<>();

            tutorials = tutorialPage.getContent();


            map.put("tutorials", tutorials);
            map.put("currentPage", tutorialPage.getNumber());
            map.put("totalItems", tutorialPage.getTotalElements());
            map.put("totalPages", tutorialPage.getTotalPages());

            return new ResponseEntity<>(map, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/sortedTutorials")
    public ResponseEntity<Map<String, Object>> getAllTutorialsPage(@RequestParam(required = false) String title,
                                                                   @RequestParam(defaultValue = "0") int page,
                                                                   @RequestParam(defaultValue = "3") int size,
                                                                   @RequestParam(defaultValue = "id,desc")
                                                                           String[] sort) {
        try {
            List<Order> orders = new ArrayList<Order>();
            if (sort[0].contains(",")) {
//                will sort more than 2 fields
//                sortOrder="field, direction"
                for (String sortOrder : sort) {
                    String[] _sort = sortOrder.split(",");
                    orders.add(new Order(getSortDirection(_sort[1]), _sort[0]));
                }
            } else {
//                sort=[field, direction]
                orders.add(new Order(getSortDirection(sort[1]), sort[0]));
            }

            List<Tutorial> tutorials = new ArrayList<Tutorial>();
            Pageable pageable = PageRequest.of(page, size, Sort.by(orders));

            Page<Tutorial> tutorialPage;
            if (title == null) {
                tutorialPage = tutorialRepository.findAll(pageable);
            } else {
                tutorialPage = tutorialRepository.findByTitleContaining(title, pageable);
            }

            tutorials = tutorialPage.getContent();
            if (tutorials.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            Map<String, Object> map = new HashMap<>();
            map.put("tutorials", tutorials);
            map.put("currentPage", tutorialPage.getNumber());
            map.put("totalItems", tutorialPage.getTotalElements());
            map.put("totalPages", tutorialPage.getTotalPages());

            return new ResponseEntity<>(map, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/tutorials/sort")
    public ResponseEntity<List<Tutorial>> getAllTutorials(
            @RequestParam(defaultValue = "id,desc") String[] sort) {
        try {
            List<Order> orders = new ArrayList<>();

            if (sort[0].contains(",")) {
//                will sort more than 2 fields,
//                sortOrder = "field, direction"
                for (String sortOrder : sort) {
                    String[] _sort = sortOrder.split(",");
                    orders.add(new Order(getSortDirection(_sort[1]), _sort[0]));
                }
            } else {
//                sort=[field, direction]
                orders.add(new Order(getSortDirection(sort[1]), sort[0]));
            }

            List<Tutorial> tutorials = tutorialRepository.findAll(Sort.by(orders));

            if (tutorials.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(tutorials, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/tutorials")
    public ResponseEntity<Tutorial> createTutorial(@RequestBody Tutorial tutorial) {
        try {
            Tutorial _tutorial = tutorialRepository.save(new Tutorial(tutorial.getTitle(),
                    tutorial.getDescription(), false));
            return new ResponseEntity<>(_tutorial, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
