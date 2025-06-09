// package com.mediquity.employee;

// import com.mediquity.employee.bean.Employee;
// import com.mediquity.employee.controller.EmployeeController;
// import com.mediquity.employee.service.EmployeeService;

// import org.junit.jupiter.api.Test;

// import static org.mockito.Mockito.*;
// import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
// import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

// import java.util.Arrays;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
// import org.springframework.boot.test.mock.mockito.MockBean;
// import org.springframework.test.web.servlet.MockMvc;

// @WebMvcTest(EmployeeController.class)
// class EmployeeControllerTest {

//     @Autowired
//     private MockMvc mockMvc;

//     @SuppressWarnings("removal")
//     @MockBean //injects a mock into the Spring application context
//     private EmployeeService employeeService;

//     @Test
//     void testShowAllEmployees() throws Exception {
//         when(employeeService.getAllEmployee()).thenReturn(
//             Arrays.asList(new Employee(1, "Alice", "alice@gmail.com", "1111"))
//         );

//         mockMvc.perform(get("/home"))
//             .andExpect(status().isOk())
//             .andExpect(view().name("home"))
//             .andExpect(model().attributeExists("employees"));
//     }

//     @Test
//     void testShowAddForm() throws Exception {
//         mockMvc.perform(get("/employee/add"))
//             .andExpect(status().isOk())
//             .andExpect(view().name("add-employee-form"))
//             .andExpect(model().attributeExists("employee"));
//     }

//     @Test
//     void testShowEditForm() throws Exception {
//         Employee mockEmp = new Employee(1, "Bob", "bob@example.com", "9999");
//         when(employeeService.getEmpById(1)).thenReturn(mockEmp);

//         mockMvc.perform(get("/employee/edit/1"))
//             .andExpect(status().isOk())
//             .andExpect(view().name("edit-employee-form"))
//             .andExpect(model().attributeExists("employee"));
//     }

//     @Test
//     void testCreateEmp_RedirectsOnSuccess() throws Exception {
//         mockMvc.perform(post("/employee")
//             .param("name", "Test")
//             .param("email", "test@example.com")
//             .param("contactNum", "1234567890"))
//             .andExpect(status().is3xxRedirection())
//             .andExpect(redirectedUrl("/home"));
//     }

//     @Test
//     void testUpdateEmp_RedirectsOnSuccess() throws Exception {
//         mockMvc.perform(post("/employee/update/1")
//             .param("name", "Updated")
//             .param("email", "updated@example.com")
//             .param("contactNum", "0000111122"))
//             .andExpect(status().is3xxRedirection())
//             .andExpect(redirectedUrl("/home"));
//     }

//     @Test
//     void testDeleteEmp_Redirects() throws Exception {
//         mockMvc.perform(post("/employee/delete/1"))
//             .andExpect(status().is3xxRedirection())
//             .andExpect(redirectedUrl("/home"));
//     }
// }
