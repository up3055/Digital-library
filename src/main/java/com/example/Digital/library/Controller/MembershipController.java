package com.example.Digital.library.Controller;

import com.example.Digital.library.Adapter.MemberShipAdapter;
import com.example.Digital.library.Entity.Input.MembershipInputEntity;
import com.example.Digital.library.Enum.MembershipStatus;
import com.example.Digital.library.Model.MemberShipModel;
import com.example.Digital.library.exceptions.MembershipExceptional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Membership")
public class MembershipController {

    private final MemberShipAdapter memberShipAdapter;

    @Autowired
    public MembershipController (MemberShipAdapter memberShipAdapter){
        this.memberShipAdapter = memberShipAdapter;
    }

    @PostMapping("/addMembership")
    public ResponseEntity<?> addMembership(@Valid @RequestBody MembershipInputEntity membershipInputEntity) {
        try {
            return new ResponseEntity<>(this.memberShipAdapter.addMemberShip(membershipInputEntity), HttpStatus.CREATED);
        } catch (MembershipExceptional e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PatchMapping("/update/{userId}")
    public ResponseEntity<?> changeMembershipStatus(@PathVariable long userId, @RequestParam MembershipStatus status) {
        if (status == MembershipStatus.EXPIRED) {
            return new ResponseEntity<>("User cannot change the membership status to EXPIRED.", HttpStatus.BAD_REQUEST);
        }
        try {
            return new ResponseEntity<>(this.memberShipAdapter.updateMembership(userId, status), HttpStatus.OK);
        } catch (MembershipExceptional e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
