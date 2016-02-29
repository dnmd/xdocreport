
/**
 * Copyright (C) 2011-2015 The XDocReport Team <xdocreport@googlegroups.com>
 *
 * All rights reserved.
 *
 * Permission is hereby granted, free  of charge, to any person obtaining
 * a  copy  of this  software  and  associated  documentation files  (the
 * "Software"), to  deal in  the Software without  restriction, including
 * without limitation  the rights to  use, copy, modify,  merge, publish,
 * distribute,  sublicense, and/or sell  copies of  the Software,  and to
 * permit persons to whom the Software  is furnished to do so, subject to
 * the following conditions:
 *
 * The  above  copyright  notice  and  this permission  notice  shall  be
 * included in all copies or substantial portions of the Software.
 *
 * THE  SOFTWARE IS  PROVIDED  "AS  IS", WITHOUT  WARRANTY  OF ANY  KIND,
 * EXPRESS OR  IMPLIED, INCLUDING  BUT NOT LIMITED  TO THE  WARRANTIES OF
 * MERCHANTABILITY,    FITNESS    FOR    A   PARTICULAR    PURPOSE    AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
 * LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
 * OF CONTRACT, TORT OR OTHERWISE,  ARISING FROM, OUT OF OR IN CONNECTION
 * WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package fr.opensagres.xdocreport.samples.docxandfreemarker;

import java.io.InputStream;
import java.io.StringWriter;
import java.util.HashMap;

import org.junit.Assert;
import org.junit.Test;

import fr.opensagres.xdocreport.core.io.IOUtils;
import fr.opensagres.xdocreport.document.docx.preprocessor.sax.DocxPreprocessor;
import fr.opensagres.xdocreport.template.formatter.IDocumentFormatter;
import fr.opensagres.xdocreport.template.freemarker.FreemarkerDocumentFormatter;

/**
 * See https://code.google.com/p/xdocreport/issues/detail?id=401
 *
 */
public class Issue119  {

	@Test
    public void issue119()
        throws Exception
    {
        DocxPreprocessor preprocessor = new DocxPreprocessor();
        
        String xml = 
        	"<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>" + 
        	"<w:document xmlns:wpc=\"http://schemas.microsoft.com/office/word/2010/wordprocessingCanvas\" xmlns:mc=\"http://schemas.openxmlformats.org/markup-compatibility/2006\" xmlns:o=\"urn:schemas-microsoft-com:office:office\" xmlns:r=\"http://schemas.openxmlformats.org/officeDocument/2006/relationships\" xmlns:m=\"http://schemas.openxmlformats.org/officeDocument/2006/math\" xmlns:v=\"urn:schemas-microsoft-com:vml\" xmlns:wp14=\"http://schemas.microsoft.com/office/word/2010/wordprocessingDrawing\" xmlns:wp=\"http://schemas.openxmlformats.org/drawingml/2006/wordprocessingDrawing\" xmlns:w10=\"urn:schemas-microsoft-com:office:word\" xmlns:w=\"http://schemas.openxmlformats.org/wordprocessingml/2006/main\" xmlns:w14=\"http://schemas.microsoft.com/office/word/2010/wordml\" xmlns:wpg=\"http://schemas.microsoft.com/office/word/2010/wordprocessingGroup\" xmlns:wpi=\"http://schemas.microsoft.com/office/word/2010/wordprocessingInk\" xmlns:wne=\"http://schemas.microsoft.com/office/word/2006/wordml\" xmlns:wps=\"http://schemas.microsoft.com/office/word/2010/wordprocessingShape\" mc:Ignorable=\"w14 wp14\">" + 
        	"	<w:body>" + 
        	"		<w:p w:rsidR=\"00BF0D53\" w:rsidRPr=\"00E17175\" w:rsidRDefault=\"00BF0D53\" w:rsidP=\"00BF0D53\">" + 
        	"			<w:pPr>" + 
        	"				<w:spacing w:line=\"240\" w:lineRule=\"auto\"/>" + 
        	"				<w:rPr>" + 
        	"					<w:color w:val=\"BFBFBF\" w:themeColor=\"background1\" w:themeShade=\"BF\"/>" + 
        	"				</w:rPr>" + 
        	"			</w:pPr>" + 
        	"			<w:r>" + 
        	"				<w:fldChar w:fldCharType=\"begin\"/>" + 
        	"			</w:r>" + 
        	"			<w:r>" + 
        	"				<w:instrText xml:space=\"preserve\"> MERGEFIELD  \"[#if du!?size &gt;0]\"  \\* MERGEFORMAT </w:instrText>" + 
        	"			</w:r>" + 
        	"			<w:r>" + 
        	"				<w:fldChar w:fldCharType=\"separate\"/>" + 
        	"			</w:r>" + 
        	"			<w:r>" + 
        	"				<w:rPr>" + 
        	"					<w:noProof/>" + 
        	"					<w:color w:val=\"BFBFBF\" w:themeColor=\"background1\" w:themeShade=\"BF\"/>" + 
        	"				</w:rPr>" + 
        	"				<w:t>«[#if du!?size &gt;0]»</w:t>" + 
        	"			</w:r>" + 
        	"			<w:r>" + 
        	"				<w:rPr>" + 
        	"					<w:noProof/>" + 
        	"					<w:color w:val=\"BFBFBF\" w:themeColor=\"background1\" w:themeShade=\"BF\"/>" + 
        	"				</w:rPr>" + 
        	"				<w:fldChar w:fldCharType=\"end\"/>" + 
        	"			</w:r>" + 
        	"		</w:p>" + 
        	"		<w:tbl>" + 
        	"			<w:tblPr>" + 
        	"				<w:tblStyle w:val=\"TableGrid\"/>" + 
        	"				<w:tblW w:w=\"0\" w:type=\"auto\"/>" + 
        	"				<w:tblLook w:val=\"04A0\" w:firstRow=\"1\" w:lastRow=\"0\" w:firstColumn=\"1\" w:lastColumn=\"0\" w:noHBand=\"0\" w:noVBand=\"1\"/>" + 
        	"			</w:tblPr>" + 
        	"			<w:tblGrid>" + 
        	"				<w:gridCol w:w=\"2438\"/>" + 
        	"			</w:tblGrid>" + 
        	"			<w:tr w:rsidR=\"00BF0D53\" w:rsidRPr=\"00380EC5\" w:rsidTr=\"00BF0D53\">" + 
        	"				<w:tc>" + 
        	"					<w:tcPr>" + 
        	"						<w:tcW w:w=\"2438\" w:type=\"dxa\"/>" + 
        	"					</w:tcPr>" + 
        	"					<w:p w:rsidR=\"00BF0D53\" w:rsidRPr=\"00380EC5\" w:rsidRDefault=\"00BF0D53\" w:rsidP=\"00CB306B\">" + 
        	"						<w:pPr>" + 
        	"							<w:rPr>" + 
        	"								<w:b/>" + 
        	"							</w:rPr>" + 
        	"						</w:pPr>" + 
        	"						<w:proofErr w:type=\"spellStart\"/>" + 
        	"						<w:r w:rsidRPr=\"001B22CE\">" + 
        	"							<w:rPr>" + 
        	"								<w:b/>" + 
        	"							</w:rPr>" + 
        	"							<w:t>Número</w:t>" + 
        	"						</w:r>" + 
        	"						<w:proofErr w:type=\"spellEnd\"/>" + 
        	"						<w:r w:rsidRPr=\"001B22CE\">" + 
        	"							<w:rPr>" + 
        	"								<w:b/>" + 
        	"							</w:rPr>" + 
        	"							<w:t xml:space=\"preserve\"> (E o Aroma)</w:t>" + 
        	"						</w:r>" + 
        	"					</w:p>" + 
        	"				</w:tc>" + 
        	"			</w:tr>" + 
        	"			<w:tr w:rsidR=\"00BF0D53\" w:rsidRPr=\"00653B6C\" w:rsidTr=\"00BF0D53\">" + 
        	"				<w:tc>" + 
        	"					<w:tcPr>" + 
        	"						<w:tcW w:w=\"5040\" w:type=\"dxa\"/>" + 
        	"					</w:tcPr>" + 
        	"					<w:p w:rsidR=\"00421F7D\" w:rsidRPr=\"00653B6C\" w:rsidRDefault=\"00E82B83\" w:rsidP=\"00380EC5\">" + 
        	"						<w:r>" + 
        	"							<w:fldChar w:fldCharType=\"begin\"/>" + 
        	"						</w:r>" + 
        	"						<w:r>" + 
        	"							<w:instrText xml:space=\"preserve\"> MERGEFIELD  ${du.no</w:instrText>" + 
        	"						</w:r>" + 
        	"						<w:r>" + 
        	"							<w:instrText xml:space=\"preserve\">}  \\* MERGEFORMAT </w:instrText>" + 
        	"						</w:r>" + 
        	"						<w:r>" + 
        	"							<w:fldChar w:fldCharType=\"separate\"/>" + 
        	"						</w:r>" + 
        	"						<w:r w:rsidR=\"00380EC5\" w:rsidRPr=\"00653B6C\">" + 
        	"							<w:rPr>" + 
        	"								<w:noProof/>" + 
        	"							</w:rPr>" + 
        	"							<w:t>«${du.no}»</w:t>" + 
        	"						</w:r>" + 
        	"						<w:r>" + 
        	"							<w:rPr>" + 
        	"								<w:noProof/>" + 
        	"							</w:rPr>" + 
        	"							<w:fldChar w:fldCharType=\"end\"/>" + 
        	"						</w:r>" + 
        	"					</w:p>" + 
        	"				</w:tc>			" + 
        	"			</w:tr>" + 
        	"		</w:tbl>" + 
        	"		<w:p w:rsidR=\"00BF0D53\" w:rsidRPr=\"00E17175\" w:rsidRDefault=\"00BF0D53\" w:rsidP=\"00BF0D53\">" + 
        	"			<w:pPr>" + 
        	"				<w:spacing w:line=\"240\" w:lineRule=\"auto\"/>" + 
        	"			</w:pPr>" + 
        	"		</w:p>" + 
        	"		<w:p w:rsidR=\"00BF0D53\" w:rsidRPr=\"0052714B\" w:rsidRDefault=\"00BF0D53\" w:rsidP=\"00BF0D53\">" + 
        	"			<w:pPr>" + 
        	"				<w:spacing w:line=\"240\" w:lineRule=\"auto\"/>" + 
        	"				<w:rPr>" + 
        	"					<w:lang w:val=\"es-ES_tradnl\"/>" + 
        	"				</w:rPr>" + 
        	"			</w:pPr>" + 
        	"			<w:r w:rsidRPr=\"0052714B\">" + 
        	"				<w:rPr>" + 
        	"					<w:lang w:val=\"es-ES_tradnl\"/>" + 
        	"				</w:rPr>" + 
        	"				<w:t xml:space=\"preserve\">La pureza de los aditivos de doble uso empleados en este Producto respeta los criterios establecidos en el anexo I del Reglamento (UE) n° 10/2011.  </w:t>" + 
        	"			</w:r>" + 
        	"		</w:p>" + 
        	"		<w:p w:rsidR=\"00BF0D53\" w:rsidRPr=\"0052714B\" w:rsidRDefault=\"00BF0D53\" w:rsidP=\"00BF0D53\">" + 
        	"			<w:pPr>" + 
        	"				<w:spacing w:line=\"240\" w:lineRule=\"auto\"/>" + 
        	"				<w:rPr>" + 
        	"					<w:color w:val=\"BFBFBF\" w:themeColor=\"background1\" w:themeShade=\"BF\"/>" + 
        	"					<w:lang w:val=\"es-ES_tradnl\"/>" + 
        	"				</w:rPr>" + 
        	"			</w:pPr>" + 
        	"			<w:r>" + 
        	"				<w:fldChar w:fldCharType=\"begin\"/>" + 
        	"			</w:r>" + 
        	"			<w:r w:rsidRPr=\"004E2CC4\">" + 
        	"				<w:rPr>" + 
        	"					<w:lang w:val=\"es-ES_tradnl\"/>" + 
        	"				</w:rPr>" + 
        	"				<w:instrText xml:space=\"preserve\"> MERGEFIELD  [#else]  \\* MERGEFORMAT </w:instrText>" + 
        	"			</w:r>" + 
        	"			<w:r>" + 
        	"				<w:fldChar w:fldCharType=\"separate\"/>" + 
        	"			</w:r>" + 
        	"			<w:r w:rsidRPr=\"0052714B\">" + 
        	"				<w:rPr>" + 
        	"					<w:noProof/>" + 
        	"					<w:color w:val=\"BFBFBF\" w:themeColor=\"background1\" w:themeShade=\"BF\"/>" + 
        	"					<w:lang w:val=\"es-ES_tradnl\"/>" + 
        	"				</w:rPr>" + 
        	"				<w:t>«[#else]»</w:t>" + 
        	"			</w:r>" + 
        	"			<w:r>" + 
        	"				<w:rPr>" + 
        	"					<w:noProof/>" + 
        	"					<w:color w:val=\"BFBFBF\" w:themeColor=\"background1\" w:themeShade=\"BF\"/>" + 
        	"					<w:lang w:val=\"es-ES_tradnl\"/>" + 
        	"				</w:rPr>" + 
        	"				<w:fldChar w:fldCharType=\"end\"/>" + 
        	"			</w:r>" + 
        	"			<w:r w:rsidRPr=\"0052714B\">" + 
        	"				<w:rPr>" + 
        	"					<w:lang w:val=\"es-ES_tradnl\"/>" + 
        	"				</w:rPr>" + 
        	"				<w:t xml:space=\"preserve\"> Este producto no contiene ningún aditivo de doble uso.</w:t>" + 
        	"			</w:r>" + 
        	"			<w:r w:rsidRPr=\"0052714B\">" + 
        	"				<w:rPr>" + 
        	"					<w:lang w:val=\"es-ES_tradnl\"/>" + 
        	"				</w:rPr>" + 
        	"				<w:br/>" + 
        	"			</w:r>" + 
        	"			<w:r>" + 
        	"				<w:fldChar w:fldCharType=\"begin\"/>" + 
        	"			</w:r>" + 
        	"			<w:r w:rsidRPr=\"004E2CC4\">" + 
        	"				<w:rPr>" + 
        	"					<w:lang w:val=\"es-ES_tradnl\"/>" + 
        	"				</w:rPr>" + 
        	"				<w:instrText xml:space=\"preserve\"> MERGEFIELD  [/#if]  \\* MERGEFORMAT </w:instrText>" + 
        	"			</w:r>" + 
        	"			<w:r>" + 
        	"				<w:fldChar w:fldCharType=\"separate\"/>" + 
        	"			</w:r>" + 
        	"			<w:r w:rsidRPr=\"0052714B\">" + 
        	"				<w:rPr>" + 
        	"					<w:noProof/>" + 
        	"					<w:color w:val=\"BFBFBF\" w:themeColor=\"background1\" w:themeShade=\"BF\"/>" + 
        	"					<w:lang w:val=\"es-ES_tradnl\"/>" + 
        	"				</w:rPr>" + 
        	"				<w:t>«[/#if]»</w:t>" + 
        	"			</w:r>" + 
        	"			<w:r>" + 
        	"				<w:rPr>" + 
        	"					<w:noProof/>" + 
        	"					<w:color w:val=\"BFBFBF\" w:themeColor=\"background1\" w:themeShade=\"BF\"/>" + 
        	"					<w:lang w:val=\"es-ES_tradnl\"/>" + 
        	"				</w:rPr>" + 
        	"				<w:fldChar w:fldCharType=\"end\"/>" + 
        	"			</w:r>" + 
        	"		</w:p>" + 
        	"		<w:p w:rsidR=\"00B17816\" w:rsidRDefault=\"00B17816\"/>" + 
        	"		<w:p w:rsidR=\"00E90B0F\" w:rsidRPr=\"00E17175\" w:rsidRDefault=\"00E90B0F\" w:rsidP=\"00E90B0F\">" + 
        	"			<w:pPr>" + 
        	"				<w:spacing w:line=\"240\" w:lineRule=\"auto\"/>" + 
        	"				<w:rPr>" + 
        	"					<w:color w:val=\"BFBFBF\" w:themeColor=\"background1\" w:themeShade=\"BF\"/>" + 
        	"				</w:rPr>" + 
        	"			</w:pPr>" + 
        	"			<w:r>" + 
        	"				<w:rPr>" + 
        	"					<w:color w:val=\"BFBFBF\" w:themeColor=\"background1\" w:themeShade=\"BF\"/>" + 
        	"				</w:rPr>" + 
        	"				<w:fldChar w:fldCharType=\"begin\"/>" + 
        	"			</w:r>" + 
        	"			<w:r>" + 
        	"				<w:rPr>" + 
        	"					<w:color w:val=\"BFBFBF\" w:themeColor=\"background1\" w:themeShade=\"BF\"/>" + 
        	"				</w:rPr>" + 
        	"				<w:instrText xml:space=\"preserve\"> MERGEFIELD  \"[#if du!?size &gt;0]\"  \\* MERGEFORMAT </w:instrText>" + 
        	"			</w:r>" + 
        	"			<w:r>" + 
        	"				<w:rPr>" + 
        	"					<w:color w:val=\"BFBFBF\" w:themeColor=\"background1\" w:themeShade=\"BF\"/>" + 
        	"				</w:rPr>" + 
        	"				<w:fldChar w:fldCharType=\"separate\"/>" + 
        	"			</w:r>" + 
        	"			<w:r>" + 
        	"				<w:rPr>" + 
        	"					<w:noProof/>" + 
        	"					<w:color w:val=\"BFBFBF\" w:themeColor=\"background1\" w:themeShade=\"BF\"/>" + 
        	"				</w:rPr>" + 
        	"				<w:t>«[#if du!?size &gt;0]»</w:t>" + 
        	"			</w:r>" + 
        	"			<w:r>" + 
        	"				<w:rPr>" + 
        	"					<w:color w:val=\"BFBFBF\" w:themeColor=\"background1\" w:themeShade=\"BF\"/>" + 
        	"				</w:rPr>" + 
        	"				<w:fldChar w:fldCharType=\"end\"/>" + 
        	"			</w:r>" + 
        	"			<w:bookmarkStart w:id=\"0\" w:name=\"_GoBack\"/>" + 
        	"			<w:bookmarkEnd w:id=\"0\"/>" + 
        	"		</w:p>" + 
        	"		<w:tbl>" + 
        	"			<w:tblPr>" + 
        	"				<w:tblStyle w:val=\"TableGrid\"/>" + 
        	"				<w:tblW w:w=\"0\" w:type=\"auto\"/>" + 
        	"				<w:tblLayout w:type=\"fixed\"/>" + 
        	"				<w:tblLook w:val=\"04A0\" w:firstRow=\"1\" w:lastRow=\"0\" w:firstColumn=\"1\" w:lastColumn=\"0\" w:noHBand=\"0\" w:noVBand=\"1\"/>" + 
        	"			</w:tblPr>" + 
        	"			<w:tblGrid>" + 
        	"				<w:gridCol w:w=\"2932\"/>" + 
        	"			</w:tblGrid>" + 
        	"			<w:tr w:rsidR=\"00E90B0F\" w:rsidRPr=\"00060003\" w:rsidTr=\"00E90B0F\">" + 
        	"				<w:tc>" + 
        	"					<w:tcPr>" + 
        	"						<w:tcW w:w=\"2932\" w:type=\"dxa\"/>" + 
        	"					</w:tcPr>" + 
        	"					<w:p w:rsidR=\"00E90B0F\" w:rsidRPr=\"00060003\" w:rsidRDefault=\"00E90B0F\" w:rsidP=\"00CB306B\">" + 
        	"						<w:pPr>" + 
        	"							<w:rPr>" + 
        	"								<w:b/>" + 
        	"							</w:rPr>" + 
        	"						</w:pPr>" + 
        	"						<w:r w:rsidRPr=\"00060003\">" + 
        	"							<w:rPr>" + 
        	"								<w:b/>" + 
        	"							</w:rPr>" + 
        	"							<w:t xml:space=\"preserve\">FCM number </w:t>" + 
        	"						</w:r>" + 
        	"					</w:p>" + 
        	"				</w:tc>" + 
        	"			</w:tr>" + 
        	"			<w:tr w:rsidR=\"00E90B0F\" w:rsidRPr=\"005A256E\" w:rsidTr=\"00E90B0F\">" + 
        	"				<w:tc>" + 
        	"					<w:tcPr>" + 
        	"						<w:tcW w:w=\"4518\" w:type=\"dxa\"/>" + 
        	"					</w:tcPr>" + 
        	"					<w:p w:rsidR=\"009425E2\" w:rsidRPr=\"005A256E\" w:rsidRDefault=\"003F64C3\" w:rsidP=\"009425E2\">" + 
        	"						<w:r>" + 
        	"							<w:fldChar w:fldCharType=\"begin\"/>" + 
        	"						</w:r>" + 
        	"						<w:r>" + 
        	"							<w:instrText xml:space=\"preserve\"> MERGEFIELD  $</w:instrText>" + 
        	"						</w:r>" + 
        	"						<w:r>" + 
        	"							<w:instrText xml:space=\"preserve\">{du.no}  \\* MERGEFORMAT </w:instrText>" + 
        	"						</w:r>" + 
        	"						<w:r>" + 
        	"							<w:fldChar w:fldCharType=\"separate\"/>" + 
        	"						</w:r>" + 
        	"						<w:r w:rsidR=\"008D3605\" w:rsidRPr=\"005A256E\">" + 
        	"							<w:rPr>" + 
        	"								<w:noProof/>" + 
        	"							</w:rPr>" + 
        	"							<w:t>«${du.no}»</w:t>" + 
        	"						</w:r>" + 
        	"						<w:r>" + 
        	"							<w:rPr>" + 
        	"								<w:noProof/>" + 
        	"							</w:rPr>" + 
        	"							<w:fldChar w:fldCharType=\"end\"/>" + 
        	"						</w:r>" + 
        	"					</w:p>" + 
        	"				</w:tc>	" + 
        	"			</w:tr>" + 
        	"		</w:tbl>" + 
        	"		<w:p w:rsidR=\"00E90B0F\" w:rsidRPr=\"00E17175\" w:rsidRDefault=\"00E90B0F\" w:rsidP=\"00E90B0F\">" + 
        	"			<w:pPr>" + 
        	"				<w:spacing w:line=\"240\" w:lineRule=\"auto\"/>" + 
        	"				<w:rPr>" + 
        	"					<w:color w:val=\"BFBFBF\" w:themeColor=\"background1\" w:themeShade=\"BF\"/>" + 
        	"				</w:rPr>" + 
        	"			</w:pPr>" + 
        	"			<w:r>" + 
        	"				<w:rPr>" + 
        	"					<w:color w:val=\"BFBFBF\" w:themeColor=\"background1\" w:themeShade=\"BF\"/>" + 
        	"				</w:rPr>" + 
        	"				<w:fldChar w:fldCharType=\"begin\"/>" + 
        	"			</w:r>" + 
        	"			<w:r>" + 
        	"				<w:rPr>" + 
        	"					<w:color w:val=\"BFBFBF\" w:themeColor=\"background1\" w:themeShade=\"BF\"/>" + 
        	"				</w:rPr>" + 
        	"				<w:instrText xml:space=\"preserve\"> MERGEFIELD  [#else]  \\* MERGEFORMAT </w:instrText>" + 
        	"			</w:r>" + 
        	"			<w:r>" + 
        	"				<w:rPr>" + 
        	"					<w:color w:val=\"BFBFBF\" w:themeColor=\"background1\" w:themeShade=\"BF\"/>" + 
        	"				</w:rPr>" + 
        	"				<w:fldChar w:fldCharType=\"separate\"/>" + 
        	"			</w:r>" + 
        	"			<w:r>" + 
        	"				<w:rPr>" + 
        	"					<w:noProof/>" + 
        	"					<w:color w:val=\"BFBFBF\" w:themeColor=\"background1\" w:themeShade=\"BF\"/>" + 
        	"				</w:rPr>" + 
        	"				<w:t>«[#else]»</w:t>" + 
        	"			</w:r>" + 
        	"			<w:r>" + 
        	"				<w:rPr>" + 
        	"					<w:color w:val=\"BFBFBF\" w:themeColor=\"background1\" w:themeShade=\"BF\"/>" + 
        	"				</w:rPr>" + 
        	"				<w:fldChar w:fldCharType=\"end\"/>" + 
        	"			</w:r>" + 
        	"		</w:p>" + 
        	"		<w:p w:rsidR=\"00E90B0F\" w:rsidRPr=\"00E17175\" w:rsidRDefault=\"00E90B0F\" w:rsidP=\"00E90B0F\">" + 
        	"			<w:pPr>" + 
        	"				<w:spacing w:line=\"240\" w:lineRule=\"auto\"/>" + 
        	"			</w:pPr>" + 
        	"			<w:r w:rsidRPr=\"00E17175\">" + 
        	"				<w:t>All substances comply with the applicable limita</w:t>" + 
        	"			</w:r>" + 
        	"			<w:r>" + 
        	"				<w:t>tions.</w:t>" + 
        	"			</w:r>" + 
        	"		</w:p>" + 
        	"		<w:p w:rsidR=\"00E90B0F\" w:rsidRPr=\"00E17175\" w:rsidRDefault=\"00E90B0F\" w:rsidP=\"00E90B0F\">" + 
        	"			<w:pPr>" + 
        	"				<w:spacing w:line=\"240\" w:lineRule=\"auto\"/>" + 
        	"				<w:rPr>" + 
        	"					<w:color w:val=\"BFBFBF\" w:themeColor=\"background1\" w:themeShade=\"BF\"/>" + 
        	"				</w:rPr>" + 
        	"			</w:pPr>" + 
        	"			<w:r>" + 
        	"				<w:rPr>" + 
        	"					<w:color w:val=\"BFBFBF\" w:themeColor=\"background1\" w:themeShade=\"BF\"/>" + 
        	"				</w:rPr>" + 
        	"				<w:fldChar w:fldCharType=\"begin\"/>" + 
        	"			</w:r>" + 
        	"			<w:r>" + 
        	"				<w:rPr>" + 
        	"					<w:color w:val=\"BFBFBF\" w:themeColor=\"background1\" w:themeShade=\"BF\"/>" + 
        	"				</w:rPr>" + 
        	"				<w:instrText xml:space=\"preserve\"> MERGEFIELD  [/#if]  \\* MERGEFORMAT </w:instrText>" + 
        	"			</w:r>" + 
        	"			<w:r>" + 
        	"				<w:rPr>" + 
        	"					<w:color w:val=\"BFBFBF\" w:themeColor=\"background1\" w:themeShade=\"BF\"/>" + 
        	"				</w:rPr>" + 
        	"				<w:fldChar w:fldCharType=\"separate\"/>" + 
        	"			</w:r>" + 
        	"			<w:r>" + 
        	"				<w:rPr>" + 
        	"					<w:noProof/>" + 
        	"					<w:color w:val=\"BFBFBF\" w:themeColor=\"background1\" w:themeShade=\"BF\"/>" + 
        	"				</w:rPr>" + 
        	"				<w:t>«[/#if]»</w:t>" + 
        	"			</w:r>" + 
        	"			<w:r>" + 
        	"				<w:rPr>" + 
        	"					<w:color w:val=\"BFBFBF\" w:themeColor=\"background1\" w:themeShade=\"BF\"/>" + 
        	"				</w:rPr>" + 
        	"				<w:fldChar w:fldCharType=\"end\"/>" + 
        	"			</w:r>" + 
        	"		</w:p>" + 
        	"		<w:p w:rsidR=\"00E90B0F\" w:rsidRDefault=\"00E90B0F\"/>" + 
        	"		<w:sectPr w:rsidR=\"00E90B0F\" w:rsidSect=\"00370FAF\">" + 
        	"			<w:pgSz w:w=\"12240\" w:h=\"15840\"/>" + 
        	"			<w:pgMar w:top=\"1704\" w:right=\"1440\" w:bottom=\"1440\" w:left=\"1440\" w:header=\"720\" w:footer=\"720\" w:gutter=\"0\"/>" + 
        	"			<w:cols w:space=\"720\"/>" + 
        	"			<w:docGrid w:linePitch=\"360\"/>" + 
        	"		</w:sectPr>" + 
        	"	</w:body>" + 
        	"</w:document>";
        	
        	
        InputStream stream =
                        IOUtils.toInputStream( xml, "UTF-8"  );

        StringWriter writer = new StringWriter();
        IDocumentFormatter formatter = new FreemarkerDocumentFormatter();
 
        preprocessor.preprocess( "word/document.xml", stream, writer, null, formatter, new HashMap<String, Object>() );
        
        System.err.println(writer.toString());
        
        Assert.assertEquals( xml, writer.toString() );
    }
}
