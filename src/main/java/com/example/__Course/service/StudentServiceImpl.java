package com.example.__Course.service;

import com.example.__Course.po.Student;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService{
    @Autowired
    private com.example.__Course.dao.StudentRepository StudentRepository;

    @Transactional
    @Override
    public Student saveStudent(Student student) {
        return StudentRepository.save(student);
    }

    @Transactional
    @Override
    public Student getStudent(Long id) {
        return StudentRepository.findById(id).orElse(null);
    }
//
//    @Override
//    public Student getStudentByContext(String name) {
//        return StudentRepository.findByName(name);
//    }

    @Transactional
    @Override
    public Page<Student> listStudent(Pageable pageable) {
        return StudentRepository.findAll(pageable);
    }

    @Override
    public List<Student> listStudent() {
        return StudentRepository.findAll();
    }


    @Override
    public List<Student> listStudent(String ids) { //1.2.3
        return StudentRepository.findAllById(converToList(ids));
    }

//    @Override
//    public List<Student> listStudentTop(Integer size) {
//        Sort sort=null;
//        Pageable pageable = PageRequest.of(0,size, sort.by(Sort.Direction.DESC,"blogs.size"));;
//        return StudentRepository.findTop(pageable);
//    }

    private List<Long> converToList(String ids){
        List<Long> list = new ArrayList<>();
        if(!"".equals(ids) && ids!=null){
            String[] idarray = ids.split(",");
            for(int i=0;i< idarray.length;i++){
                list.add(new Long(idarray[i]));
            }
        }
        return list;
    }

    @Transactional
    @Override
    public Student updateStudent(Long id, Student student) throws NotFoundException {
        Student t = StudentRepository.findById(id).orElse(null);
        if(t == null){
            throw new NotFoundException("不存在該標簽");
        }

        return StudentRepository.save(t);
    }

    @Transactional
    @Override
    public void deleteStudent(Long id) {
        StudentRepository.deleteById(id);
    }

    @Override
    public List<Student> listStudentByCourseId(Long id) {
        return StudentRepository.findByCourseId(id);
    }

    @Override
    public List<Student> listStudent(String query, Pageable pageable) {
        return StudentRepository.findByQuery(query,pageable);
    }

    @Override
    public Optional<Student> getStudentById(Long id) {
        return StudentRepository.findById(id);
    }
}
