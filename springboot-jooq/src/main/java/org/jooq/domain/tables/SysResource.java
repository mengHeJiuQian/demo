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
import org.jooq.domain.tables.records.SysResourceRecord;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;


/**
 * 资源表
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.11.11"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class SysResource extends TableImpl<SysResourceRecord> {

    private static final long serialVersionUID = -624768470;

    /**
     * The reference instance of <code>springboot_demo.sys_resource</code>
     */
    public static final SysResource SYS_RESOURCE = new SysResource();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<SysResourceRecord> getRecordType() {
        return SysResourceRecord.class;
    }

    /**
     * The column <code>springboot_demo.sys_resource.id</code>. 编号
     */
    public final TableField<SysResourceRecord, Long> ID = createField("id", org.jooq.impl.SQLDataType.BIGINT.nullable(false).identity(true), this, "编号");

    /**
     * The column <code>springboot_demo.sys_resource.name</code>. 名称
     */
    public final TableField<SysResourceRecord, String> NAME = createField("name", org.jooq.impl.SQLDataType.VARCHAR(100), this, "名称");

    /**
     * The column <code>springboot_demo.sys_resource.type</code>. 资源类型
     */
    public final TableField<SysResourceRecord, String> TYPE = createField("type", org.jooq.impl.SQLDataType.VARCHAR(50), this, "资源类型");

    /**
     * The column <code>springboot_demo.sys_resource.url</code>. 链接地址
     */
    public final TableField<SysResourceRecord, String> URL = createField("url", org.jooq.impl.SQLDataType.VARCHAR(200), this, "链接地址");

    /**
     * The column <code>springboot_demo.sys_resource.parent_id</code>. 父编号
     */
    public final TableField<SysResourceRecord, Long> PARENT_ID = createField("parent_id", org.jooq.impl.SQLDataType.BIGINT, this, "父编号");

    /**
     * The column <code>springboot_demo.sys_resource.parent_ids</code>. 父编号列表
     */
    public final TableField<SysResourceRecord, String> PARENT_IDS = createField("parent_ids", org.jooq.impl.SQLDataType.VARCHAR(100), this, "父编号列表");

    /**
     * The column <code>springboot_demo.sys_resource.permission</code>. 权限字符串
     */
    public final TableField<SysResourceRecord, String> PERMISSION = createField("permission", org.jooq.impl.SQLDataType.VARCHAR(100), this, "权限字符串");

    /**
     * The column <code>springboot_demo.sys_resource.available</code>. 是否有效
     */
    public final TableField<SysResourceRecord, Byte> AVAILABLE = createField("available", org.jooq.impl.SQLDataType.TINYINT.defaultValue(org.jooq.impl.DSL.inline("0", org.jooq.impl.SQLDataType.TINYINT)), this, "是否有效");

    /**
     * The column <code>springboot_demo.sys_resource.icon</code>. 图标
     */
    public final TableField<SysResourceRecord, String> ICON = createField("icon", org.jooq.impl.SQLDataType.VARCHAR(100), this, "图标");

    /**
     * The column <code>springboot_demo.sys_resource.priority</code>. 优先级
     */
    public final TableField<SysResourceRecord, Integer> PRIORITY = createField("priority", org.jooq.impl.SQLDataType.INTEGER, this, "优先级");

    /**
     * The column <code>springboot_demo.sys_resource.leaf</code>. 叶子节点
     */
    public final TableField<SysResourceRecord, Byte> LEAF = createField("leaf", org.jooq.impl.SQLDataType.TINYINT.defaultValue(org.jooq.impl.DSL.inline("0", org.jooq.impl.SQLDataType.TINYINT)), this, "叶子节点");

    /**
     * Create a <code>springboot_demo.sys_resource</code> table reference
     */
    public SysResource() {
        this(DSL.name("sys_resource"), null);
    }

    /**
     * Create an aliased <code>springboot_demo.sys_resource</code> table reference
     */
    public SysResource(String alias) {
        this(DSL.name(alias), SYS_RESOURCE);
    }

    /**
     * Create an aliased <code>springboot_demo.sys_resource</code> table reference
     */
    public SysResource(Name alias) {
        this(alias, SYS_RESOURCE);
    }

    private SysResource(Name alias, Table<SysResourceRecord> aliased) {
        this(alias, aliased, null);
    }

    private SysResource(Name alias, Table<SysResourceRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment("资源表"));
    }

    public <O extends Record> SysResource(Table<O> child, ForeignKey<O, SysResourceRecord> key) {
        super(child, key, SYS_RESOURCE);
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
        return Arrays.<Index>asList(Indexes.SYS_RESOURCE_IDX_SYS_RESOURCE_PARENT_ID, Indexes.SYS_RESOURCE_IDX_SYS_RESOURCE_PARENT_IDS, Indexes.SYS_RESOURCE_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Identity<SysResourceRecord, Long> getIdentity() {
        return Keys.IDENTITY_SYS_RESOURCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<SysResourceRecord> getPrimaryKey() {
        return Keys.KEY_SYS_RESOURCE_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<SysResourceRecord>> getKeys() {
        return Arrays.<UniqueKey<SysResourceRecord>>asList(Keys.KEY_SYS_RESOURCE_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SysResource as(String alias) {
        return new SysResource(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SysResource as(Name alias) {
        return new SysResource(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public SysResource rename(String name) {
        return new SysResource(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public SysResource rename(Name name) {
        return new SysResource(name, null);
    }
}
