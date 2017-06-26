package com.fzrj.architect.labor.source.db.mysql;

import java.util.List;
import java.util.Set;

import com.fzrj.architect.labor.utils.StringUtil;

/**
 * @className:com.fzrj.architect.labor.source.db.mysql.Table
 * @description:表信息
 * @version:v1.0.0
 * @date:2017年6月22日 下午5:02:17
 * @author:WangHao
 */
public class Table
{
	// 表原名--aquatic_all_price_info
	private String name;
	// 表名大写--AQUATIC_ALL_PRICE_INFO
	private String upperName;
	// 类名首字母大写--AquaticAllPriceInfo
	private String upperFirstLetterName;
	// 类名首字母小写--aquaticAllPriceInfo
	private String lowerFirstLetterName;
	// 包名
	private String packageName;
	// 字段列表
	private List<Column> columns;

	private String primaryKey;

	private String primaryKeyType;

	private String upperFirstLetterPrimaryKey;

	private String lowerFirstLetterPrimaryKey;

	public String getUpperFirstLetterPrimaryKey()
	{
		return upperFirstLetterPrimaryKey;
	}

	public void setUpperFirstLetterPrimaryKey(String upperFirstLetterPrimaryKey)
	{
		this.upperFirstLetterPrimaryKey = upperFirstLetterPrimaryKey;
	}

	private List<TableIndex> tableIndexs;

	private List<TableBind> tableBinds;

	private Set<String> importPojos;

	// column名转换为属性名后，逗号拼接
	// id, priceKey, shopKey..
	private String stringCarrayNames1;

	// 属性名与属性类型拼接
	// Integer id, String priceKey, String shopKey..
	private String stringCarrayNames2;

	// column名逗号拼接,无id
	// price_key, shop_key, goods_key..
	private String stringCarrayNames3;

	// "#%s#,"格式,无id
	// #{priceKey}, #{shopKey}, #{goodsKey}..
	private String stringCarrayNames4;

	// "%s=#%s#,"格式，无id
	// price_key=#{priceKey}, shop_key=#{shopKey}, goods_key=#{goodsKey}..
	private String stringCarrayNames5;

	// column名
	// id, price_key, shop_key..
	private String stringCarrayNames6;

	// "%s as %s,"格式，含id
	// id as id,price_key as priceKey,shop_key as shopKey..
	private String stringCarrayNames7;

	private String stringCarrayNames8;

	private String allTablesName;

	private String sourceDbSchema;

	public Table(String name, String classNameD, String classNameX, String packageName, List<Column> columns,
			List<TableIndex> tableIndexs, List<TableBind> tableBinds, Set<String> importPojos,
			String stringCarrayNames1, String stringCarrayNames2, String stringCarrayNames3, String stringCarrayNames4,
			String stringCarrayNames5, String stringCarrayNames6, String stringCarrayNames7)
	{
		super();
		this.name = name;
		upperFirstLetterName = classNameD;
		lowerFirstLetterName = classNameX;
		this.packageName = packageName;
		this.columns = columns;
		this.tableIndexs = tableIndexs;
		this.tableBinds = tableBinds;
		this.importPojos = importPojos;
		this.stringCarrayNames1 = stringCarrayNames1;
		this.stringCarrayNames2 = stringCarrayNames2;
		this.stringCarrayNames3 = stringCarrayNames3;
		this.stringCarrayNames4 = stringCarrayNames4;
		this.stringCarrayNames5 = stringCarrayNames5;

		this.stringCarrayNames6 = stringCarrayNames6;
		this.stringCarrayNames7 = stringCarrayNames7;
	}

	public String getUpperPrimaryKey()
	{
		return primaryKey.toUpperCase();
	}

	public String getPrimaryKey()
	{
		return primaryKey;
	}

	public void setPrimaryKey(String primaryKey)
	{
		this.primaryKey = primaryKey;
	}

	public String getPrimaryKeyType()
	{
		return primaryKeyType;
	}

	public void setPrimaryKeyType(String primaryKeyType)
	{
		this.primaryKeyType = primaryKeyType;
	}

	public String getStringCarrayNames8()
	{
		return stringCarrayNames8;
	}

	public void setStringCarrayNames8(String stringCarrayNames8)
	{
		this.stringCarrayNames8 = stringCarrayNames8;
	}

	public String getName()
	{
		return name;
	}

	public String getLowerFirstLetterPrimaryKey()
	{
		return lowerFirstLetterPrimaryKey;
	}

	public void setLowerFirstLetterPrimaryKey(String lowerFirstLetterPrimaryKey)
	{
		this.lowerFirstLetterPrimaryKey = lowerFirstLetterPrimaryKey;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getJooqName()
	{
		// String startS = upperFirstLetterName.substring(0,1);
		// String ends = upperFirstLetterName.substring(1,
		// upperFirstLetterName.length());
		// return startS.toUpperCase()+ends.toLowerCase();
		String[] tempNames = name.toLowerCase().split("_");
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < tempNames.length; i++)
		{
			sb.append(StringUtil.upperFirst(tempNames[i]));
		}
		return sb.toString();

	}

	public String getUpperFirstLetterName()
	{
		return upperFirstLetterName;
	}

	public void setUpperFirstLetterName(String classNameD)
	{
		upperFirstLetterName = classNameD;
	}

	public String getLowerFirstLetterName()
	{
		return lowerFirstLetterName;
	}

	public void setLowerFirstLetterName(String classNameX)
	{
		lowerFirstLetterName = classNameX;
	}

	public List<Column> getColumns()
	{
		return columns;
	}

	public void setColumns(List<Column> columns)
	{
		this.columns = columns;
	}

	public List<TableIndex> getTableIndexs()
	{
		return tableIndexs;
	}

	public void setTableIndexs(List<TableIndex> tableIndexs)
	{
		this.tableIndexs = tableIndexs;
	}

	public List<TableBind> getTableBinds()
	{
		return tableBinds;
	}

	public void setTableBinds(List<TableBind> tableBinds)
	{
		this.tableBinds = tableBinds;
	}

	public Set<String> getImportPojos()
	{
		return importPojos;
	}

	public void setImportPojos(Set<String> importPojos)
	{
		this.importPojos = importPojos;
	}

	public String getStringCarrayNames1()
	{
		return stringCarrayNames1;
	}

	public void setStringCarrayNames1(String stringCarrayNames1)
	{
		this.stringCarrayNames1 = stringCarrayNames1;
	}

	public String getStringCarrayNames2()
	{
		return stringCarrayNames2;
	}

	public void setStringCarrayNames2(String stringCarrayNames2)
	{
		this.stringCarrayNames2 = stringCarrayNames2;
	}

	public String getStringCarrayNames3()
	{
		return stringCarrayNames3;
	}

	public void setStringCarrayNames3(String stringCarrayNames3)
	{
		this.stringCarrayNames3 = stringCarrayNames3;
	}

	public String getStringCarrayNames4()
	{
		return stringCarrayNames4;
	}

	public void setStringCarrayNames4(String stringCarrayNames4)
	{
		this.stringCarrayNames4 = stringCarrayNames4;
	}

	public String getStringCarrayNames5()
	{
		return stringCarrayNames5;
	}

	public void setStringCarrayNames5(String stringCarrayNames5)
	{
		this.stringCarrayNames5 = stringCarrayNames5;
	}

	public String getStringCarrayNames6()
	{
		return stringCarrayNames6;
	}

	public void setStringCarrayNames6(String stringCarrayNames6)
	{
		this.stringCarrayNames6 = stringCarrayNames6;
	}

	public String getStringCarrayNames7()
	{
		return stringCarrayNames7;
	}

	public void setStringCarrayNames7(String stringCarrayNames7)
	{
		this.stringCarrayNames7 = stringCarrayNames7;
	}

	public String getPackageName()
	{
		return packageName;
	}

	public void setPackageName(String packageName)
	{
		this.packageName = packageName;
	}

	public String getStringCarrayNames9()
	{
		if (columns == null)
			return "";
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < columns.size(); i++)
		{
			if (getPrimaryKey().equals(columns.get(i).getName())) // ignore
																	// primary
																	// key
				continue;
			if (!"".equals(sb.toString()))
				sb.append(", ");
			sb.append(columns.get(i).getName() + " = ?");
		}
		return sb.toString();
	}

	public String getStringCarrayNames10()
	{
		if (columns == null)
			return "";
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < columns.size(); i++)
		{
			if (getPrimaryKey().equals(columns.get(i).getName())) // ignore
																	// primary
																	// key
				continue;
			if (!"".equals(sb.toString()))
				sb.append(", ");
			sb.append(lowerFirstLetterName + ".get" + columns.get(i).getUpperFirstLetterName() + "()");
		}
		sb.append(", ").append(lowerFirstLetterName + ".get" + getUpperFirstLetterPrimaryKey() + "()");
		return sb.toString();
	}

	public String getStringCarrayNames11()
	{
		if (columns == null)
			return "";
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < columns.size(); i++)
		{
			if (getPrimaryKey().equals(columns.get(i).getName())) // ignore
																	// primary
																	// key
				continue;
			if (!"".equals(sb.toString()))
				sb.append(", ");
			sb.append("?");
		}
		return sb.toString();
	}

	public String getStringCarrayNames12()
	{
		if (columns == null)
			return "";
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < columns.size(); i++)
		{
			if (getPrimaryKey().equals(columns.get(i).getName())) // ignore
																	// primary
																	// key
				continue;
			if (!"".equals(sb.toString()))
				sb.append(", ");
			sb.append(lowerFirstLetterName + ".get" + columns.get(i).getUpperFirstLetterName() + "()");
		}
		return sb.toString();
	}

	public String getUpperName()
	{
		return upperName;
	}

	public void setUpperName(String upperName)
	{
		this.upperName = upperName;
	}

	public String getAllTablesName()
	{
		return allTablesName;
	}

	public void setAllTablesName(String allTablesName)
	{
		this.allTablesName = allTablesName;
	}

	public String getSourceDbSchema()
	{
		return sourceDbSchema;
	}

	public void setSourceDbSchema(String sourceDbSchema)
	{
		this.sourceDbSchema = sourceDbSchema;
	}

	@Override
	public String toString()
	{
		return "Table [name=" + name + ", upperName=" + upperName + ", upperFirstLetterName=" + upperFirstLetterName
				+ ", lowerFirstLetterName=" + lowerFirstLetterName + ", packageName=" + packageName + ", columns="
				+ columns + ", primaryKey=" + primaryKey + ", primaryKeyType=" + primaryKeyType
				+ ", upperFirstLetterPrimaryKey=" + upperFirstLetterPrimaryKey + ", lowerFirstLetterPrimaryKey="
				+ lowerFirstLetterPrimaryKey + ", tableIndexs=" + tableIndexs + ", tableBinds=" + tableBinds
				+ ", importPojos=" + importPojos + ", stringCarrayNames1=" + stringCarrayNames1
				+ ", stringCarrayNames2=" + stringCarrayNames2 + ", stringCarrayNames3=" + stringCarrayNames3
				+ ", stringCarrayNames4=" + stringCarrayNames4 + ", stringCarrayNames5=" + stringCarrayNames5
				+ ", stringCarrayNames6=" + stringCarrayNames6 + ", stringCarrayNames7=" + stringCarrayNames7
				+ ", stringCarrayNames8=" + stringCarrayNames8 + ", allTablesName=" + allTablesName
				+ ", sourceDbSchema=" + sourceDbSchema + "]";
	}
}
