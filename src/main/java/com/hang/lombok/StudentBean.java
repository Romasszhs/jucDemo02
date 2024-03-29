package com.hang.lombok;

import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.constraints.NotNull;

/**
 * @author: hangshuo
 * @date: 2021/05/19 15:23
 * @Description:
 */

@Accessors(chain = true)
@Getter
@Setter
@RequiredArgsConstructor(staticName = "of",onConstructor = @__(@Autowired))
// staticName作为外部调用private构造器的方法
@Builder
@ToString
public class StudentBean {
    @NonNull
    private String name;

    @NonNull
    private int age;

    /*public static Builder builder(){
        return new Builder();
    }*/

    /*public static class Builder{
        private String name;

        private int age;

        public Builder name(String name){
            this.name = name;
            return this;
        }

        public Builder age(int age) {
            this.age = age;
            return this;
        }

        public StudentBean build() {
            StudentBean studentBean = new StudentBean();
            studentBean.setName(name);
            studentBean.setAge(age);
            return studentBean;
        }
    }*/
}
