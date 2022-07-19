package net.internalerror.addressbook.data.util;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;

@MappedSuperclass
public class AEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "create_date", nullable = false)
    private Date createDate;

    @Column(name = "update_date", nullable = false)
    private Date updateDate;

    @PrePersist
    protected void prePersist(){
        this.createDate = Date.valueOf(LocalDate.now());
    }

    @PreUpdate
    protected void preUpdate(){
        this.createDate = Date.valueOf(LocalDate.now());
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean filter(String filter){
        return false;
    }
}
