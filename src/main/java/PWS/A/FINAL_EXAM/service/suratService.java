/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PWS.A.FINAL_EXAM.service;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutionException;
import org.springframework.stereotype.Service;

import PWS.A.FINAL_EXAM.model.entity.Surat;

/**
 *
 * @author MADD
 */
@Service
public class suratService
{
    private static final String COLLECTION_NAME = "surat";
    
    public String save(Surat surat) throws InterruptedException, ExecutionException{
        Firestore dbfirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collectionApiFuture= dbfirestore.collection(COLLECTION_NAME)
                .document(surat.getID())
                .set(surat);

        return collectionApiFuture.get().getUpdateTime().toString() ;
    }

    public Surat getSurat(String ID) throws InterruptedException, ExecutionException{
        Firestore dbfirestore = FirestoreClient.getFirestore();
        DocumentReference documentReference=dbfirestore.collection(COLLECTION_NAME).document(ID);
        ApiFuture<DocumentSnapshot> future = documentReference.get();

        DocumentSnapshot doc = future.get();

        Surat student = null;
        
        if(doc.exists()){
            student = doc.toObject(Surat.class);
        }

        return student;
    }

    public String update(Surat surat) throws InterruptedException, ExecutionException{
        Firestore dbfirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collectionApiFuture= dbfirestore.collection(COLLECTION_NAME).document(surat.getID()).set(surat);

        return collectionApiFuture.get().getUpdateTime().toString() ;
    }

    public String delete(String ID) throws InterruptedException, ExecutionException{
        Firestore dbfirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collectionApiFuture= dbfirestore.collection(COLLECTION_NAME).document(ID).delete();

        return "Data with ID : " + ID + " Has been Deleted";
    }

    public List<Surat> getSuratAll() throws InterruptedException, ExecutionException
    {
        Firestore dbfirestore = FirestoreClient.getFirestore();

        Iterable<DocumentReference> documentReference=dbfirestore.collection(COLLECTION_NAME).listDocuments();
        Iterator<DocumentReference> iterator = documentReference.iterator();

        List<Surat> studentList=new ArrayList<>();
        Surat student = null;

        while(iterator.hasNext()){
            DocumentReference documentReference1=iterator.next();
            ApiFuture<DocumentSnapshot> future=documentReference1.get();
            DocumentSnapshot doc = future.get();
           student = doc.toObject(Surat.class);
           studentList.add(student);
        }
        return studentList;
    }
}
