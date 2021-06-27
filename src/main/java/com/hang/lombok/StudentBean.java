package com.hang.lombok;

import lombok.*;
import lombok.experimental.Accessors;

/**
 * @author: hangshuo
 * @date: 2021/05/19 15:23
 * @Description:
 */

@Accessors(chain = true)
@Getter
@Setter
@RequiredArgsConstructor(staticName = "of")
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
