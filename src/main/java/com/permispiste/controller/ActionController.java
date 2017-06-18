package com.permispiste.controller;

import com.permispiste.dao.ActionDAO;
import com.permispiste.model.ActionEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by JOYMANGUL Jensen Selwyn
 * on 6/17/2017.
 */
@Controller
public class ActionController {
    private ActionDAO actionDAO;

    public ActionController() {
        super();
        actionDAO = new ActionDAO();
    }

    @RequestMapping(value = "/actions", method = RequestMethod.GET)
    public ModelAndView list(HttpServletRequest request, HttpServletResponse response) throws Exception {
        request.setAttribute("actions", actionDAO.findAll());
        return new ModelAndView("actions/list");
    }

    @RequestMapping(value = "/action/ajouter")
    public ModelAndView add(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ActionEntity action = new ActionEntity();

        // Todo : Finish the action DAO

//        if (updateOrInsertValid(action, request)) {
//            actionDAO.insert(action);
//            return list(request, response);
//        }


        return new ModelAndView("actions/add");
    }
}
