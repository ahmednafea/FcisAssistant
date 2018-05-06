package FcisAssistant;

import android.util.Log;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class FirebaseClass {
   private static DatabaseReference root= FirebaseDatabase.getInstance().getReference();
   private static FirebaseAuth auth=FirebaseAuth.getInstance();
   private static String TAG= "FCIS";
    public static void AddUser(String id,String email,String password){
        DatabaseReference target=root.child("Users");
        target.child(id).child("Email").setValue(email);
        target.child(id).child("Password").setValue(password);
    }
     public static void AddStudent(Student student){
         DatabaseReference target=root.child("Students").child(student.getID());
         target.child("Name").setValue(student.getName());
         target.child("Gender").setValue(student.getGender());
         target.child("Email").setValue(student.getEmail());
         target.child("Password").setValue(student.getPassword());
         target.child("Credit_Hours").setValue(student.getCreditHours());
         target.child("Remain_Credit_Hours").setValue(student.getRCreditHours());
         target.child("Academic_Year").setValue(student.getAcademicYear());
         target.child("Department").setValue(student.getDepartment());
         target.child("Cumulative_Gpa").setValue(student.getCumulativeGpa());
         target.child("Total_Credit_Hours").setValue(student.getTotalCreditHours());
         target.child("Remain_Total_Credit_Hours").setValue(student.getRTotalCreditHours());
         for (int i=0;i<student.Courselist.size();i++) {
             String indx=String.valueOf(i);
             target.child("Courses").child(indx).setValue(student.Courselist.get(i));
         }

     }
    public static Student GetStudentInfo(String id){
        final DatabaseReference target=root.child("Students").child(id);
        final Student student=new Student();
        target.child("Name").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                student.setName(dataSnapshot.getValue(String.class));
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.w(TAG, "Failed to read value.", databaseError.toException());
            }
        });
        target.child("Gender").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                student.setGender(dataSnapshot.getValue(String.class));
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.w(TAG, "Failed to read value.", databaseError.toException());
            }
        });
        target.child("Email").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                student.setEmail(dataSnapshot.getValue(String.class));
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.w(TAG, "Failed to read value.", databaseError.toException());
            }
        });
        target.child("Password").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                student.setPassword(dataSnapshot.getValue(String.class));
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.w(TAG, "Failed to read value.", databaseError.toException());
            }
        });
        target.child("Credit_Hours").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                student.setCreditHours(Integer.parseInt(dataSnapshot.getValue(String.class)));
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.w(TAG, "Failed to read value.", databaseError.toException());
            }
        });
        target.child("Remain_Credit_Hours").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                student.setRCreditHours(Integer.parseInt(dataSnapshot.getValue(String.class)));
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.w(TAG, "Failed to read value.", databaseError.toException());
            }
        });
        target.child("Academic_Year").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                student.setAcademicYear(dataSnapshot.getValue(String.class));
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.w(TAG, "Failed to read value.", databaseError.toException());
            }
        });
        target.child("Department").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                student.setDepartment(dataSnapshot.getValue(String.class));
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.w(TAG, "Failed to read value.", databaseError.toException());
            }
        });
        target.child("Cumulative_Gpa").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                student.setCumulativeGpa(Float.parseFloat(dataSnapshot.getValue(String.class)));
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.w(TAG, "Failed to read value.", databaseError.toException());
            }
        });
        target.child("Total_Credit_Hours").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                student.setTotalCreditHours(Integer.parseInt(dataSnapshot.getValue(String.class)));
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.w(TAG, "Failed to read value.", databaseError.toException());
            }
        });
        target.child("Remain_Total_Credit_Hours").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                student.setRTotalCreditHours(Integer.parseInt(dataSnapshot.getValue(String.class)));
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.w(TAG, "Failed to read value.", databaseError.toException());
            }
        });
        target.child("Courses")
                .addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                             student.Courselist.add(snapshot.getValue(StudentCourse.class));
                        }
                    }
                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        Log.w(TAG, "Failed to read value.", databaseError.toException());
                    }
                });
        return student;
    }

     public static void AddInstructor(Instructor instructor){
         DatabaseReference target=root.child("Instructors").child(instructor.getID());
         target.child("Name").setValue(instructor.getName());
         target.child("Gender").setValue(instructor.getGender());
         target.child("Email").setValue(instructor.getEmail());
         target.child("Password").setValue(instructor.getPassword());
         target.child("No_of_Evaluators").setValue(instructor.getNoofEvaluators());
         target.child("Total_Evaluation").setValue(instructor.getTotalEvaluation());
         target.child("Office_Hours").setValue(instructor.getOfficeHours());
         for (int i=0;i<instructor.Courselist.size();i++) {
             String indx=String.valueOf(i);
             target.child("Courses").child(indx).setValue(instructor.Courselist.get(i));
         }
     }
     public static Instructor GetInstructorInfo(String id){
         DatabaseReference target=root.child("Instructors").child(id);
         final Instructor instructor=new Instructor();
         target.child("Name").addValueEventListener(new ValueEventListener() {
             @Override
             public void onDataChange(DataSnapshot dataSnapshot) {
                 instructor.setName(dataSnapshot.getValue(String.class));
             }

             @Override
             public void onCancelled(DatabaseError databaseError) {
                 Log.w(TAG, "Failed to read value.", databaseError.toException());
             }
         });
         target.child("Gender").addValueEventListener(new ValueEventListener() {
             @Override
             public void onDataChange(DataSnapshot dataSnapshot) {
                 instructor.setGender(dataSnapshot.getValue(String.class));
             }

             @Override
             public void onCancelled(DatabaseError databaseError) {
                 Log.w(TAG, "Failed to read value.", databaseError.toException());
             }
         });
         target.child("Email").addValueEventListener(new ValueEventListener() {
             @Override
             public void onDataChange(DataSnapshot dataSnapshot) {
                 instructor.setEmail(dataSnapshot.getValue(String.class));
             }

             @Override
             public void onCancelled(DatabaseError databaseError) {
                 Log.w(TAG, "Failed to read value.", databaseError.toException());
             }
         });
         target.child("Password").addValueEventListener(new ValueEventListener() {
             @Override
             public void onDataChange(DataSnapshot dataSnapshot) {
                 instructor.setPassword(dataSnapshot.getValue(String.class));
             }

             @Override
             public void onCancelled(DatabaseError databaseError) {
                 Log.w(TAG, "Failed to read value.", databaseError.toException());
             }
         });
         target.child("No_of_Evaluators").addValueEventListener(new ValueEventListener() {
             @Override
             public void onDataChange(DataSnapshot dataSnapshot) {
                 instructor.setNoofEvaluators(Integer.parseInt(dataSnapshot.getValue(String.class)));
             }

             @Override
             public void onCancelled(DatabaseError databaseError) {
                 Log.w(TAG, "Failed to read value.", databaseError.toException());
             }
         });
         target.child("Total_Evaluation").addValueEventListener(new ValueEventListener() {
             @Override
             public void onDataChange(DataSnapshot dataSnapshot) {
                 instructor.setTotalEvaluation(Float.parseFloat(dataSnapshot.getValue(String.class)));
             }

             @Override
             public void onCancelled(DatabaseError databaseError) {
                 Log.w(TAG, "Failed to read value.", databaseError.toException());
             }
         });
         target.child("Office_Hours").addValueEventListener(new ValueEventListener() {
             @Override
             public void onDataChange(DataSnapshot dataSnapshot) {
                 instructor.setOfficeHours(dataSnapshot.getValue(String.class));
             }

             @Override
             public void onCancelled(DatabaseError databaseError) {
                 Log.w(TAG, "Failed to read value.", databaseError.toException());
             }
         });
         target.child("Courses")
                 .addListenerForSingleValueEvent(new ValueEventListener() {
                     @Override
                     public void onDataChange(DataSnapshot dataSnapshot) {
                         for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                             instructor.Courselist.add(snapshot.getValue(InstructorCourse.class));
                         }
                     }
                     @Override
                     public void onCancelled(DatabaseError databaseError) {
                         Log.w(TAG, "Failed to read value.", databaseError.toException());
                     }
                 });
         return instructor;
     }
     public static void AddTA(TeacherAssistant teacherAssistant){
         DatabaseReference target=root.child("Teacher_Assistants").child(teacherAssistant.getID());
         target.child("Name").setValue(teacherAssistant.getName());
         target.child("Gender").setValue(teacherAssistant.getGender());
         target.child("Email").setValue(teacherAssistant.getEmail());
         target.child("Password").setValue(teacherAssistant.getPassword());
         target.child("No_of_Evaluators").setValue(teacherAssistant.getNoofEvaluators());
         target.child("Total_Evaluation").setValue(teacherAssistant.getTotalEvaluation());
         target.child("Department").setValue(teacherAssistant.getDepartment());
         target.child("Credit_Hours").setValue(teacherAssistant.getCreditHours());
         target.child("Remain_Credit_Hours").setValue(teacherAssistant.getRCreditHours());
         for (int i=0;i<teacherAssistant.Courselist.size();i++) {
             String indx=String.valueOf(i);
             target.child("Courses").child(indx).setValue(teacherAssistant.Courselist.get(i));
         }
     }
     public static TeacherAssistant GetTAInfo(String id){
         DatabaseReference target=root.child("Teacher_Assistants").child(id);
         final TeacherAssistant teacherAssistant=new TeacherAssistant();
         target.child("Name").addValueEventListener(new ValueEventListener() {
             @Override
             public void onDataChange(DataSnapshot dataSnapshot) {
                 teacherAssistant.setName(dataSnapshot.getValue(String.class));
             }

             @Override
             public void onCancelled(DatabaseError databaseError) {
                 Log.w(TAG, "Failed to read value.", databaseError.toException());
             }
         });
         target.child("Gender").addValueEventListener(new ValueEventListener() {
             @Override
             public void onDataChange(DataSnapshot dataSnapshot) {
                 teacherAssistant.setGender(dataSnapshot.getValue(String.class));
             }

             @Override
             public void onCancelled(DatabaseError databaseError) {
                 Log.w(TAG, "Failed to read value.", databaseError.toException());
             }
         });
         target.child("Email").addValueEventListener(new ValueEventListener() {
             @Override
             public void onDataChange(DataSnapshot dataSnapshot) {
                 teacherAssistant.setEmail(dataSnapshot.getValue(String.class));
             }

             @Override
             public void onCancelled(DatabaseError databaseError) {
                 Log.w(TAG, "Failed to read value.", databaseError.toException());
             }
         });
         target.child("Password").addValueEventListener(new ValueEventListener() {
             @Override
             public void onDataChange(DataSnapshot dataSnapshot) {
                 teacherAssistant.setPassword(dataSnapshot.getValue(String.class));
             }

             @Override
             public void onCancelled(DatabaseError databaseError) {
                 Log.w(TAG, "Failed to read value.", databaseError.toException());
             }
         });
         target.child("No_of_Evaluators").addValueEventListener(new ValueEventListener() {
             @Override
             public void onDataChange(DataSnapshot dataSnapshot) {
                 teacherAssistant.setNoofEvaluators(Integer.parseInt(dataSnapshot.getValue(String.class)));
             }

             @Override
             public void onCancelled(DatabaseError databaseError) {
                 Log.w(TAG, "Failed to read value.", databaseError.toException());
             }
         });
         target.child("Total_Evaluation").addValueEventListener(new ValueEventListener() {
             @Override
             public void onDataChange(DataSnapshot dataSnapshot) {
                 teacherAssistant.setTotalEvaluation(Float.parseFloat(dataSnapshot.getValue(String.class)));
             }

             @Override
             public void onCancelled(DatabaseError databaseError) {
                 Log.w(TAG, "Failed to read value.", databaseError.toException());
             }
         });
         target.child("Department").addValueEventListener(new ValueEventListener() {
             @Override
             public void onDataChange(DataSnapshot dataSnapshot) {
                 teacherAssistant.setDepartment(dataSnapshot.getValue(String.class));
             }

             @Override
             public void onCancelled(DatabaseError databaseError) {
                 Log.w(TAG, "Failed to read value.", databaseError.toException());
             }
         });
         target.child("Credit_Hours").addValueEventListener(new ValueEventListener() {
             @Override
             public void onDataChange(DataSnapshot dataSnapshot) {
                 teacherAssistant.setCreditHours(Integer.parseInt(dataSnapshot.getValue(String.class)));
             }

             @Override
             public void onCancelled(DatabaseError databaseError) {
                 Log.w(TAG, "Failed to read value.", databaseError.toException());
             }
         });
         target.child("Remain_Credit_Hours").addValueEventListener(new ValueEventListener() {
             @Override
             public void onDataChange(DataSnapshot dataSnapshot) {
                 teacherAssistant.setRCreditHours(Integer.parseInt(dataSnapshot.getValue(String.class)));
             }

             @Override
             public void onCancelled(DatabaseError databaseError) {
                 Log.w(TAG, "Failed to read value.", databaseError.toException());
             }
         });
         target.child("Courses")
                 .addListenerForSingleValueEvent(new ValueEventListener() {
                     @Override
                     public void onDataChange(DataSnapshot dataSnapshot) {
                         for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                             teacherAssistant.Courselist.add(snapshot.getValue(TACourse.class));
                         }
                     }
                     @Override
                     public void onCancelled(DatabaseError databaseError) {
                         Log.w(TAG, "Failed to read value.", databaseError.toException());
                     }
                 });
         return teacherAssistant;
     }
     public static void AddCourse(Course course){
         DatabaseReference target=root.child("Courses").child(course.getCode());
         target.child("Name").setValue(course.getName());
         target.child("Credit_Hours").setValue(course.getCreditHours());
         target.child("Image").setValue(course.getImage());
         target.child("Instructor_of_Course").setValue(course.getInstructorofCourse());
         for (int i=0;i<course.TAlist.size();i++) {
             String indx=String.valueOf(i);
             target.child("Teacher_Assistants").child(indx).setValue(course.TAlist.get(i));
         }
     }
     public static Course GetCourseInfo(String Code){
         DatabaseReference target=root.child("Courses").child(Code);
         final Course course=new Course();
         target.child("Name").addValueEventListener(new ValueEventListener() {
             @Override
             public void onDataChange(DataSnapshot dataSnapshot) {
                 course.setName(dataSnapshot.getValue(String.class));
             }

             @Override
             public void onCancelled(DatabaseError databaseError) {
                 Log.w(TAG, "Failed to read value.", databaseError.toException());
             }
         });
         target.child("Credit_Hours").addValueEventListener(new ValueEventListener() {
             @Override
             public void onDataChange(DataSnapshot dataSnapshot) {
                 course.setCreditHours(Integer.parseInt(dataSnapshot.getValue(String.class)));
             }

             @Override
             public void onCancelled(DatabaseError databaseError) {
                 Log.w(TAG, "Failed to read value.", databaseError.toException());
             }
         });
         target.child("Image").addValueEventListener(new ValueEventListener() {
             @Override
             public void onDataChange(DataSnapshot dataSnapshot) {
                 course.setImage(Integer.parseInt(dataSnapshot.getValue(String.class)));
             }

             @Override
             public void onCancelled(DatabaseError databaseError) {
                 Log.w(TAG, "Failed to read value.", databaseError.toException());
             }
         });
         target.child("Instructor_of_Course").addValueEventListener(new ValueEventListener() {
             @Override
             public void onDataChange(DataSnapshot dataSnapshot) {
                 course.setInstructorofCourse(dataSnapshot.getValue(String.class));
             }

             @Override
             public void onCancelled(DatabaseError databaseError) {
                 Log.w(TAG, "Failed to read value.", databaseError.toException());
             }
         });
         target.child("Teacher_Assistants")
                 .addListenerForSingleValueEvent(new ValueEventListener() {
                     @Override
                     public void onDataChange(DataSnapshot dataSnapshot) {
                         for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                             course.TAlist.add(snapshot.getValue(String.class));
                         }
                     }
                     @Override
                     public void onCancelled(DatabaseError databaseError) {
                         Log.w(TAG, "Failed to read value.", databaseError.toException());
                     }
                 });
         return course;
     }
    public static boolean ChickStudentID(String id){
        final boolean[] exist = new boolean[1];
        root.child("Students").child(id).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                exist[0] = dataSnapshot.exists();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.w(TAG, "Failed to read value.", databaseError.toException());
            }
        });
        return exist[0];
    }
     public static boolean ChickStudentEmailandPassword(String id){
         final boolean[] exist = new boolean[1];
         root.child("Users").child(id).addListenerForSingleValueEvent(new ValueEventListener() {
             @Override
             public void onDataChange(DataSnapshot dataSnapshot) {
                 exist[0] = dataSnapshot.exists();
             }

             @Override
             public void onCancelled(DatabaseError databaseError) {
                 Log.w(TAG, "Failed to read value.", databaseError.toException());
             }
         });
         return exist[0];
     }
     public static void WritePost(Post post){
         DatabaseReference target=root.child("Posts").child(post.Poster);
         target.child("Post").setValue(post.PostContent);
         target.child("Gender").setValue(post.Gender);
         target.child("Time").setValue(post.PostTime);
     }
     public static ArrayList<Post> ReadPosts(){
         DatabaseReference target=root.child("Posts");
         final  ArrayList<Post>posts = new  ArrayList<>();
         target.addValueEventListener(new ValueEventListener() {
             @Override
             public void onDataChange(DataSnapshot dataSnapshot) {
                 for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                     posts.add(dataSnapshot.getValue(Post.class));
                 }
             }
             @Override
             public void onCancelled(DatabaseError databaseError) {
                 Log.w(TAG, "Failed to read value.", databaseError.toException());
             }
         });
         return posts;
     }

 }
