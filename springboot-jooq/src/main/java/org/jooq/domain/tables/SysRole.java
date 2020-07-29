/*
 * This file is generated by jOOQ.
 */
package org.jooq.domain.tables;


import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.Index;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.domain.Indexes;
import org.jooq.domain.Keys;
import org.jooq.domain.SpringbootDemo;
import org.jooq.domain.tables.records.SysRoleRecord;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;


/**
 * 角色表
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.11.11"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class SysRole extends TableImpl<SysRoleRecord> {

    private static final long serialVersionUID = -949479916;

    /**
     * The reference instance of <code>springboot_demo.sys_role</code>
     */
    public static final SysRole SYS_ROLE = new SysRole();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<SysRoleRecord> getRecordType() {
        return SysRoleRecord.class;
    }

    /**
     * The column <code>springboot_demo.sys_role.id</code>. 编号
     */
    public final TableField<SysRoleRecord, Long> ID = createField("id", org.jooq.impl.SQLDataType.BIGINT.nullable(false).identity(true), this, "编号");

    /**
     * The column <code>springboot_demo.sys_role.role</code>. 角色名
     */
    public final TableField<SysRoleRecord, String> ROLE = createField("role", org.jooq.impl.SQLDataType.VARCHAR(100), this, "角色名");

    /**
     * The column <code>springboot_demo.sys_role.description</code>. 描述
     */
    public final TableField<SysRoleRecord, String> DESCRIPTION = createField("description", org.jooq.impl.SQLDataType.VARCHAR(100), this, "描述");

    /**
     * The column <code>springboot_demo.sys_role.resource_ids</code>. 资源编号列表
     */
    public final TableField<SysRoleRecord, String> RESOURCE_IDS = createField("resource_ids", org.jooq.impl.SQLDataType.VARCHAR(1024), this, "资源编号列表");

    /**
     * The column <code>springboot_demo.sys_role.available</code>. 是否有效
     */
    public final TableField<SysRoleRecord, Byte> AVAILABLE = createField("available", org.jooq.impl.SQLDataType.TINYINT.defaultValue(org.jooq.impl.DSL.inline("0", org.jooq.impl.SQLDataType.TINYINT)), this, "是否有效");

    /**
     * Create a <code>springboot_demo.sys_role</code> table reference
     */
    public SysRole() {
        this(DSL.name("sys_role"), null);
    }

    /**
     * Create an aliased <code>springboot_demo.sys_role</code> table reference
     */
    public SysRole(String alias) {
        this(DSL.name(alias), SYS_ROLE);
    }

    /**
     * Create an aliased <code>springboot_demo.sys_role</code> table reference
     */
    public SysRole(Name alias) {
        this(alias, SYS_ROLE);
    }

    private SysRole(Name alias, Table<SysRoleRecord> aliased) {
        this(alias, aliased, null);
    }

    private SysRole(Name alias, Table<SysRoleRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment("角色表"));
    }

    public <O extends Record> SysRole(Table<O> child, ForeignKey<O, SysRoleRecord> key) {
        super(child, key, SYS_ROLE);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Schema getSchema() {
        return SpringbootDemo.SPRINGBOOT_DEMO;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Index> getIndexes() {
        return Arrays.<Index>asList(Indexes.SYS_ROLE_IDX_SYS_ROLE_RESOURCE_IDS, Indexes.SYS_ROLE_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Identity<SysRoleRecord, Long> getIdentity() {
        return Keys.IDENTITY_SYS_ROLE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<SysRoleRecord> getPrimaryKey() {
        return Keys.KEY_SYS_ROLE_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<SysRoleRecord>> getKeys() {
        return Arrays.<UniqueKey<SysRoleRecord>>asList(Keys.KEY_SYS_ROLE_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SysRole as(String alias) {
        return new SysRole(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SysRole as(Name alias) {
        return new SysRole(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public SysRole rename(String name) {
        return new SysRole(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public SysRole rename(Name name) {
        return new SysRole(name, null);
    }
}