<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:output method="html" indent="yes" />
	<xsl:template match="/">
		<html>
			<body>
				<div align="center">
					<xsl:apply-templates />
				</div>
			</body>
		</html>
	</xsl:template>
	<xsl:template match="data">
		<table border="1" width="250">
			<tr bgcolor="#eee">
				<th>Id</th>
				<th>Name</th>
				<th>Age</th>
			</tr>
			<xsl:for-each select="data">
				<tr>
					<td>
						<xsl:value-of select="id" />
					</td>
					<td>
						<xsl:value-of select="name" />
					</td>
					<td>
						<xsl:value-of select="age" />
					</td>
				</tr>
			</xsl:for-each>
		</table>
	</xsl:template>
</xsl:stylesheet>