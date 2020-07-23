/*
 * This file is generated by jOOQ.
 */
package org.jooq.domain.tables.records;


import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record7;
import org.jooq.Row7;
import org.jooq.domain.tables.Customer;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * 客户信息表
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.11.11"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class CustomerRecord extends UpdatableRecordImpl<CustomerRecord> implements Record7<Integer, String, String, String, Byte, String, String> {

    private static final long serialVersionUID = 558230603;

    /**
     * Setter for <code>springboot_demo.customer.id</code>. 主键id
     */
    public void setId(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>springboot_demo.customer.id</code>. 主键id
     */
    public Integer getId() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>springboot_demo.customer.name</code>. 客户姓名
     */
    public void setName(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>springboot_demo.customer.name</code>. 客户姓名
     */
    public String getName() {
        return (String) get(1);
    }

    /**
     * Setter for <code>springboot_demo.customer.mobile</code>. 手机号
     */
    public void setMobile(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>springboot_demo.customer.mobile</code>. 手机号
     */
    public String getMobile() {
        return (String) get(2);
    }

    /**
     * Setter for <code>springboot_demo.customer.sex</code>. 性别：男，女
     */
    public void setSex(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>springboot_demo.customer.sex</code>. 性别：男，女
     */
    public String getSex() {
        return (String) get(3);
    }

    /**
     * Setter for <code>springboot_demo.customer.locked</code>. 记录锁定：0表示可用，1表示锁定不可用
     */
    public void setLocked(Byte value) {
        set(4, value);
    }

    /**
     * Getter for <code>springboot_demo.customer.locked</code>. 记录锁定：0表示可用，1表示锁定不可用
     */
    public Byte getLocked() {
        return (Byte) get(4);
    }

    /**
     * Setter for <code>springboot_demo.customer.organization_id</code>. 客户所属组织级别
     */
    public void setOrganizationId(String value) {
        set(5, value);
    }

    /**
     * Getter for <code>springboot_demo.customer.organization_id</code>. 客户所属组织级别
     */
    public String getOrganizationId() {
        return (String) get(5);
    }

    /**
     * Setter for <code>springboot_demo.customer.organization_name</code>. 客户所属组织级别名称
     */
    public void setOrganizationName(String value) {
        set(6, value);
    }

    /**
     * Getter for <code>springboot_demo.customer.organization_name</code>. 客户所属组织级别名称
     */
    public String getOrganizationName() {
        return (String) get(6);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Record1<Integer> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record7 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row7<Integer, String, String, String, Byte, String, String> fieldsRow() {
        return (Row7) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row7<Integer, String, String, String, Byte, String, String> valuesRow() {
        return (Row7) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field1() {
        return Customer.CUSTOMER.ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field2() {
        return Customer.CUSTOMER.NAME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field3() {
        return Customer.CUSTOMER.MOBILE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field4() {
        return Customer.CUSTOMER.SEX;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Byte> field5() {
        return Customer.CUSTOMER.LOCKED;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field6() {
        return Customer.CUSTOMER.ORGANIZATION_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field7() {
        return Customer.CUSTOMER.ORGANIZATION_NAME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component1() {
        return getId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component2() {
        return getName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component3() {
        return getMobile();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component4() {
        return getSex();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Byte component5() {
        return getLocked();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component6() {
        return getOrganizationId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component7() {
        return getOrganizationName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value1() {
        return getId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value2() {
        return getName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value3() {
        return getMobile();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value4() {
        return getSex();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Byte value5() {
        return getLocked();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value6() {
        return getOrganizationId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value7() {
        return getOrganizationName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CustomerRecord value1(Integer value) {
        setId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CustomerRecord value2(String value) {
        setName(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CustomerRecord value3(String value) {
        setMobile(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CustomerRecord value4(String value) {
        setSex(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CustomerRecord value5(Byte value) {
        setLocked(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CustomerRecord value6(String value) {
        setOrganizationId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CustomerRecord value7(String value) {
        setOrganizationName(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CustomerRecord values(Integer value1, String value2, String value3, String value4, Byte value5, String value6, String value7) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached CustomerRecord
     */
    public CustomerRecord() {
        super(Customer.CUSTOMER);
    }

    /**
     * Create a detached, initialised CustomerRecord
     */
    public CustomerRecord(Integer id, String name, String mobile, String sex, Byte locked, String organizationId, String organizationName) {
        super(Customer.CUSTOMER);

        set(0, id);
        set(1, name);
        set(2, mobile);
        set(3, sex);
        set(4, locked);
        set(5, organizationId);
        set(6, organizationName);
    }
}
