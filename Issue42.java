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
public class Issue42  {

	@Test
    public void issue42()
        throws Exception
    {
        DocxPreprocessor preprocessor = new DocxPreprocessor();
        
        String xml = 
        	"<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>" + 
        	"<w:document xmlns:wpc=\"http://schemas.microsoft.com/office/word/2010/wordprocessingCanvas\" xmlns:mc=\"http://schemas.openxmlformats.org/markup-compatibility/2006\" xmlns:o=\"urn:schemas-microsoft-com:office:office\" xmlns:r=\"http://schemas.openxmlformats.org/officeDocument/2006/relationships\" xmlns:m=\"http://schemas.openxmlformats.org/officeDocument/2006/math\" xmlns:v=\"urn:schemas-microsoft-com:vml\" xmlns:wp14=\"http://schemas.microsoft.com/office/word/2010/wordprocessingDrawing\" xmlns:wp=\"http://schemas.openxmlformats.org/drawingml/2006/wordprocessingDrawing\" xmlns:w10=\"urn:schemas-microsoft-com:office:word\" xmlns:w=\"http://schemas.openxmlformats.org/wordprocessingml/2006/main\" xmlns:w14=\"http://schemas.microsoft.com/office/word/2010/wordml\" xmlns:wpg=\"http://schemas.microsoft.com/office/word/2010/wordprocessingGroup\" xmlns:wpi=\"http://schemas.microsoft.com/office/word/2010/wordprocessingInk\" xmlns:wne=\"http://schemas.microsoft.com/office/word/2006/wordml\" xmlns:wps=\"http://schemas.microsoft.com/office/word/2010/wordprocessingShape\" mc:Ignorable=\"w14 wp14\">" + 
        		"<w:body>" + 
        			"<w:p w:rsidR=\"00387A57\" w:rsidRPr=\"00E17175\" w:rsidRDefault=\"00387A57\" w:rsidP=\"00387A57\">" + 
        				"<w:pPr>" + 
        					"<w:spacing w:line=\"240\" w:lineRule=\"auto\"/>" + 
        					"<w:rPr>" + 
        						"<w:b/>" + 
        					"</w:rPr>" + 
        				"</w:pPr>" + 
        				"<w:r w:rsidRPr=\"00E17175\">" + 
        					"<w:rPr>" + 
        						"<w:b/>" + 
        					"</w:rPr>" + 
        					"<w:t xml:space=\"preserve\">7. Dual </w:t>" + 
        				"</w:r>" + 
        				"<w:r w:rsidR=\"00103428\" w:rsidRPr=\"00E17175\">" + 
        					"<w:rPr>" + 
        						"<w:b/>" + 
        					"</w:rPr>" + 
        					"<w:t>U</w:t>" + 
        				"</w:r>" + 
        				"<w:r w:rsidRPr=\"00E17175\">" + 
        					"<w:rPr>" + 
        						"<w:b/>" + 
        					"</w:rPr>" + 
        					"<w:t xml:space=\"preserve\">se </w:t>" + 
        				"</w:r>" + 
        				"<w:r w:rsidR=\"00103428\" w:rsidRPr=\"00E17175\">" + 
        					"<w:rPr>" + 
        						"<w:b/>" + 
        					"</w:rPr>" + 
        					"<w:t>A</w:t>" + 
        				"</w:r>" + 
        				"<w:r w:rsidRPr=\"00E17175\">" + 
        					"<w:rPr>" + 
        						"<w:b/>" + 
        					"</w:rPr>" + 
        					"<w:t>dditive(s)</w:t>" + 
        				"</w:r>" + 
        				"<w:bookmarkStart w:id=\"0\" w:name=\"_GoBack\"/>" + 
        				"<w:bookmarkEnd w:id=\"0\"/>" + 
        			"</w:p>" + 
        			"<w:p w:rsidR=\"00387A57\" w:rsidRPr=\"00E17175\" w:rsidRDefault=\"00387A57\" w:rsidP=\"00387A57\">" + 
        				"<w:pPr>" + 
        					"<w:spacing w:line=\"240\" w:lineRule=\"auto\"/>" + 
        				"</w:pPr>" + 
        				"<w:r w:rsidRPr=\"00E17175\">" + 
        					"<w:t xml:space=\"preserve\">A substance is defined </w:t>" + 
        				"</w:r>" + 
        				"<w:r w:rsidR=\"0007211E\" w:rsidRPr=\"00E17175\">" + 
        					"<w:t>as</w:t>" + 
        				"</w:r>" + 
        				"<w:r w:rsidR=\"00410111\" w:rsidRPr=\"00E17175\">" + 
        					"<w:t xml:space=\"preserve\"> a</w:t>" + 
        				"</w:r>" + 
        				"<w:r w:rsidR=\"0007211E\" w:rsidRPr=\"00E17175\">" + 
        					"<w:t xml:space=\"preserve\"> </w:t>" + 
        				"</w:r>" + 
        				"<w:r w:rsidRPr=\"00E17175\">" + 
        					"<w:t>\"</w:t>" + 
        				"</w:r>" + 
        				"<w:r w:rsidR=\"00103428\" w:rsidRPr=\"00E17175\">" + 
        					"<w:t>D</w:t>" + 
        				"</w:r>" + 
        				"<w:r w:rsidRPr=\"00E17175\">" + 
        					"<w:t xml:space=\"preserve\">ual </w:t>" + 
        				"</w:r>" + 
        				"<w:r w:rsidR=\"00103428\" w:rsidRPr=\"00E17175\">" + 
        					"<w:t>U</w:t>" + 
        				"</w:r>" + 
        				"<w:r w:rsidRPr=\"00E17175\">" + 
        					"<w:t xml:space=\"preserve\">se </w:t>" + 
        				"</w:r>" + 
        				"<w:r w:rsidR=\"00103428\" w:rsidRPr=\"00E17175\">" + 
        					"<w:t>A</w:t>" + 
        				"</w:r>" + 
        				"<w:r w:rsidRPr=\"00E17175\">" + 
        					"<w:t xml:space=\"preserve\">dditive\" if the chemical identity of the plastic additive matches that of an authorized food additive or flavoring, regardless of its purity or whether or not the substance is subject to a restriction in food and/or in the plastic. In </w:t>" + 
        				"</w:r>" + 
        				"<w:r w:rsidR=\"00410111\" w:rsidRPr=\"00E17175\">" + 
        					"<w:t xml:space=\"preserve\">the </w:t>" + 
        				"</w:r>" + 
        				"<w:r w:rsidRPr=\"00E17175\">" + 
        					"<w:t>case of salts it is the salt that matters, not the authorized acid, phenol or alcohol.</w:t>" + 
        				"</w:r>" + 
        			"</w:p>" + 
        			"<w:p w:rsidR=\"005E4DA4\" w:rsidRPr=\"00E17175\" w:rsidRDefault=\"005E4DA4\" w:rsidP=\"00387A57\">" + 
        				"<w:pPr>" + 
        					"<w:spacing w:line=\"240\" w:lineRule=\"auto\"/>" + 
        				"</w:pPr>" + 
        			"</w:p>" + 
        			"<w:p w:rsidR=\"00421F7D\" w:rsidRPr=\"00E17175\" w:rsidRDefault=\"00F62FE9\" w:rsidP=\"00421F7D\">" + 
        				"<w:pPr>" + 
        					"<w:spacing w:line=\"240\" w:lineRule=\"auto\"/>" + 
        					"<w:rPr>" + 
        						"<w:color w:val=\"BFBFBF\" w:themeColor=\"background1\" w:themeShade=\"BF\"/>" + 
        					"</w:rPr>" + 
        				"</w:pPr>" + 
        				"<w:r>" + 
        					"<w:rPr>" + 
        						"<w:color w:val=\"BFBFBF\" w:themeColor=\"background1\" w:themeShade=\"BF\"/>" + 
        					"</w:rPr>" + 
        					"<w:fldChar w:fldCharType=\"begin\"/>" + 
        				"</w:r>" + 
        				"<w:r>" + 
        					"<w:rPr>" + 
        						"<w:color w:val=\"BFBFBF\" w:themeColor=\"background1\" w:themeShade=\"BF\"/>" + 
        					"</w:rPr>" + 
        					"<w:instrText xml:space=\"preserve\"> MERGEFIELD  \"[#if du!?size &gt;0]\"  \\* MERGEFORMAT </w:instrText>" + 
        				"</w:r>" + 
        				"<w:r>" + 
        					"<w:rPr>" + 
        						"<w:color w:val=\"BFBFBF\" w:themeColor=\"background1\" w:themeShade=\"BF\"/>" + 
        					"</w:rPr>" + 
        					"<w:fldChar w:fldCharType=\"separate\"/>" + 
        				"</w:r>" + 
        				"<w:r>" + 
        					"<w:rPr>" + 
        						"<w:noProof/>" + 
        						"<w:color w:val=\"BFBFBF\" w:themeColor=\"background1\" w:themeShade=\"BF\"/>" + 
        					"</w:rPr>" + 
        					"<w:t>«[#if du!?size &gt;0]»</w:t>" + 
        				"</w:r>" + 
        				"<w:r>" + 
        					"<w:rPr>" + 
        						"<w:color w:val=\"BFBFBF\" w:themeColor=\"background1\" w:themeShade=\"BF\"/>" + 
        					"</w:rPr>" + 
        					"<w:fldChar w:fldCharType=\"end\"/>" + 
        				"</w:r>" + 
        			"</w:p>" + 
        			"<w:tbl>" + 
        				"<w:tblPr>" + 
        					"<w:tblStyle w:val=\"TableGrid\"/>" + 
        					"<w:tblW w:w=\"0\" w:type=\"auto\"/>" + 
        					"<w:tblLook w:val=\"04A0\" w:firstRow=\"1\" w:lastRow=\"0\" w:firstColumn=\"1\" w:lastColumn=\"0\" w:noHBand=\"0\" w:noVBand=\"1\"/>" + 
        				"</w:tblPr>" + 
        				"<w:tblGrid>" + 
        					"<w:gridCol w:w=\"1908\"/>" + 
        					"<w:gridCol w:w=\"5220\"/>" + 
        					"<w:gridCol w:w=\"2448\"/>" + 
        				"</w:tblGrid>" + 
        				"<w:tr w:rsidR=\"00380EC5\" w:rsidRPr=\"00380EC5\" w:rsidTr=\"00380EC5\">" + 
        					"<w:tc>" + 
        						"<w:tcPr>" + 
        							"<w:tcW w:w=\"1908\" w:type=\"dxa\"/>" + 
        						"</w:tcPr>" + 
        						"<w:p w:rsidR=\"00421F7D\" w:rsidRPr=\"00380EC5\" w:rsidRDefault=\"00421F7D\" w:rsidP=\"00421F7D\">" + 
        							"<w:pPr>" + 
        								"<w:rPr>" + 
        									"<w:b/>" + 
        								"</w:rPr>" + 
        							"</w:pPr>" + 
        							"<w:r w:rsidRPr=\"00380EC5\">" + 
        								"<w:rPr>" + 
        									"<w:b/>" + 
        								"</w:rPr>" + 
        								"<w:t>Number (E or FL)</w:t>" + 
        							"</w:r>" + 
        						"</w:p>" + 
        					"</w:tc>" + 
        					"<w:tc>" + 
        						"<w:tcPr>" + 
        							"<w:tcW w:w=\"5220\" w:type=\"dxa\"/>" + 
        						"</w:tcPr>" + 
        						"<w:p w:rsidR=\"00421F7D\" w:rsidRPr=\"00380EC5\" w:rsidRDefault=\"00421F7D\" w:rsidP=\"00D96E35\">" + 
        							"<w:pPr>" + 
        								"<w:rPr>" + 
        									"<w:b/>" + 
        								"</w:rPr>" + 
        							"</w:pPr>" + 
        							"<w:r w:rsidRPr=\"00380EC5\">" + 
        								"<w:rPr>" + 
        									"<w:b/>" + 
        								"</w:rPr>" + 
        								"<w:t>Name</w:t>" + 
        							"</w:r>" + 
        							"<w:r w:rsidR=\"00410111\" w:rsidRPr=\"00380EC5\">" + 
        								"<w:rPr>" + 
        									"<w:b/>" + 
        								"</w:rPr>" + 
        								"<w:t xml:space=\"preserve\"> </w:t>" + 
        							"</w:r>" + 
        						"</w:p>" + 
        					"</w:tc>" + 
        					"<w:tc>" + 
        						"<w:tcPr>" + 
        							"<w:tcW w:w=\"2448\" w:type=\"dxa\"/>" + 
        						"</w:tcPr>" + 
        						"<w:p w:rsidR=\"00421F7D\" w:rsidRPr=\"00380EC5\" w:rsidRDefault=\"00421F7D\" w:rsidP=\"00D96E35\">" + 
        							"<w:pPr>" + 
        								"<w:rPr>" + 
        									"<w:b/>" + 
        								"</w:rPr>" + 
        							"</w:pPr>" + 
        							"<w:r w:rsidRPr=\"00380EC5\">" + 
        								"<w:rPr>" + 
        									"<w:b/>" + 
        								"</w:rPr>" + 
        								"<w:t xml:space=\"preserve\">Maximum </w:t>" + 
        							"</w:r>" + 
        							"<w:r w:rsidR=\"00410111\" w:rsidRPr=\"00380EC5\">" + 
        								"<w:rPr>" + 
        									"<w:b/>" + 
        								"</w:rPr>" + 
        								"<w:t>c</w:t>" + 
        							"</w:r>" + 
        							"<w:r w:rsidRPr=\"00380EC5\">" + 
        								"<w:rPr>" + 
        									"<w:b/>" + 
        								"</w:rPr>" + 
        								"<w:t>oncentration</w:t>" + 
        							"</w:r>" + 
        							"<w:r w:rsidR=\"00410111\" w:rsidRPr=\"00380EC5\">" + 
        								"<w:rPr>" + 
        									"<w:b/>" + 
        								"</w:rPr>" + 
        								"<w:t xml:space=\"preserve\"> </w:t>" + 
        							"</w:r>" + 
        						"</w:p>" + 
        					"</w:tc>" + 
        				"</w:tr>" + 
        				"<w:tr w:rsidR=\"00653B6C\" w:rsidRPr=\"00653B6C\" w:rsidTr=\"00380EC5\">" + 
        					"<w:tc>" + 
        						"<w:tcPr>" + 
        							"<w:tcW w:w=\"1908\" w:type=\"dxa\"/>" + 
        						"</w:tcPr>" + 
        						"<w:p w:rsidR=\"00421F7D\" w:rsidRPr=\"00653B6C\" w:rsidRDefault=\"009E258F\" w:rsidP=\"00380EC5\">" + 
        							"<w:r>" + 
        								"<w:fldChar w:fldCharType=\"begin\"/>" + 
        							"</w:r>" + 
        							"<w:r>" + 
        								"<w:instrText xml:space=\"preserve\"> MERGEFIELD  ${du.no}  \\* MERGEFORMAT </w:instrText>" + 
        							"</w:r>" + 
        							"<w:r>" + 
        								"<w:fldChar w:fldCharType=\"separate\"/>" + 
        							"</w:r>" + 
        							"<w:r w:rsidR=\"00380EC5\" w:rsidRPr=\"00653B6C\">" + 
        								"<w:rPr>" + 
        									"<w:noProof/>" + 
        								"</w:rPr>" + 
        								"<w:t>«${du.no}»</w:t>" + 
        							"</w:r>" + 
        							"<w:r>" + 
        								"<w:rPr>" + 
        									"<w:noProof/>" + 
        								"</w:rPr>" + 
        								"<w:fldChar w:fldCharType=\"end\"/>" + 
        							"</w:r>" + 
        						"</w:p>" + 
        					"</w:tc>" + 
        					"<w:tc>" + 
        						"<w:tcPr>" + 
        							"<w:tcW w:w=\"5220\" w:type=\"dxa\"/>" + 
        						"</w:tcPr>" + 
        						"<w:p w:rsidR=\"00421F7D\" w:rsidRPr=\"00653B6C\" w:rsidRDefault=\"009E258F\" w:rsidP=\"00380EC5\">" + 
        							"<w:r>" + 
        								"<w:fldChar w:fldCharType=\"begin\"/>" + 
        							"</w:r>" + 
        							"<w:r>" + 
        								"<w:instrText xml:space=\"preserve\"> MERGEFIELD  ${du.name}  \\* MERGEFORMAT </w:instrText>" + 
        							"</w:r>" + 
        							"<w:r>" + 
        								"<w:fldChar w:fldCharType=\"separate\"/>" + 
        							"</w:r>" + 
        							"<w:r w:rsidR=\"00380EC5\" w:rsidRPr=\"00653B6C\">" + 
        								"<w:rPr>" + 
        									"<w:noProof/>" + 
        								"</w:rPr>" + 
        								"<w:t>«${du.name}»</w:t>" + 
        							"</w:r>" + 
        							"<w:r>" + 
        								"<w:rPr>" + 
        									"<w:noProof/>" + 
        								"</w:rPr>" + 
        								"<w:fldChar w:fldCharType=\"end\"/>" + 
        							"</w:r>" + 
        						"</w:p>" + 
        					"</w:tc>" + 
        					"<w:tc>" + 
        						"<w:tcPr>" + 
        							"<w:tcW w:w=\"2448\" w:type=\"dxa\"/>" + 
        						"</w:tcPr>" + 
        						"<w:p w:rsidR=\"00421F7D\" w:rsidRPr=\"00653B6C\" w:rsidRDefault=\"009E258F\" w:rsidP=\"00421F7D\">" + 
        							"<w:r>" + 
        								"<w:fldChar w:fldCharType=\"begin\"/>" + 
        							"</w:r>" + 
        							"<w:r>" + 
        								"<w:instrText xml:space=\"preserve\"> MERGEFIELD  ${du.maxCon}  \\* MERGEFORMAT </w:instrText>" + 
        							"</w:r>" + 
        							"<w:r>" + 
        								"<w:fldChar w:fldCharType=\"separate\"/>" + 
        							"</w:r>" + 
        							"<w:r w:rsidR=\"00380EC5\" w:rsidRPr=\"00653B6C\">" + 
        								"<w:rPr>" + 
        									"<w:noProof/>" + 
        								"</w:rPr>" + 
        								"<w:t>«${du.maxCon}»</w:t>" + 
        							"</w:r>" + 
        							"<w:r>" + 
        								"<w:rPr>" + 
        									"<w:noProof/>" + 
        								"</w:rPr>" + 
        								"<w:fldChar w:fldCharType=\"end\"/>" + 
        							"</w:r>" + 
        						"</w:p>" + 
        					"</w:tc>" + 
        				"</w:tr>" + 
        			"</w:tbl>" + 
        			"<w:p w:rsidR=\"00490DE6\" w:rsidRPr=\"00E17175\" w:rsidRDefault=\"00490DE6\" w:rsidP=\"00490DE6\">" + 
        				"<w:pPr>" + 
        					"<w:spacing w:line=\"240\" w:lineRule=\"auto\"/>" + 
        				"</w:pPr>" + 
        			"</w:p>" + 
        			"<w:p w:rsidR=\"00490DE6\" w:rsidRPr=\"00F62FE9\" w:rsidRDefault=\"00490DE6\" w:rsidP=\"00421F7D\">" + 
        				"<w:pPr>" + 
        					"<w:spacing w:line=\"240\" w:lineRule=\"auto\"/>" + 
        				"</w:pPr>" + 
        				"<w:r w:rsidRPr=\"00E17175\">" + 
        					"<w:t xml:space=\"preserve\">The purity of the Dual Use Additives used in this Product respect the purity </w:t>" + 
        				"</w:r>" + 
        				"<w:r w:rsidR=\"00573066\" w:rsidRPr=\"00E17175\">" + 
        					"<w:t xml:space=\"preserve\">criteria set out in Annex I </w:t>" + 
        				"</w:r>" + 
        				"<w:r w:rsidRPr=\"00F62FE9\">" + 
        					"<w:t xml:space=\"preserve\">of </w:t>" + 
        				"</w:r>" + 
        				"<w:r w:rsidR=\"0000519C\" w:rsidRPr=\"00F62FE9\">" + 
        					"<w:t xml:space=\"preserve\">Regulation (EU) No </w:t>" + 
        				"</w:r>" + 
        				"<w:r w:rsidRPr=\"00F62FE9\">" + 
        					"<w:t xml:space=\"preserve\">10/2011.  </w:t>" + 
        				"</w:r>" + 
        			"</w:p>" + 
        			"<w:p w:rsidR=\"00387A57\" w:rsidRPr=\"00BE6CB1\" w:rsidRDefault=\"00F62FE9\" w:rsidP=\"00856BA6\">" + 
        				"<w:pPr>" + 
        					"<w:spacing w:line=\"240\" w:lineRule=\"auto\"/>" + 
        					"<w:rPr>" + 
        						"<w:color w:val=\"BFBFBF\" w:themeColor=\"background1\" w:themeShade=\"BF\"/>" + 
        					"</w:rPr>" + 
        				"</w:pPr>" + 
        				"<w:r>" + 
        					"<w:rPr>" + 
        						"<w:color w:val=\"BFBFBF\" w:themeColor=\"background1\" w:themeShade=\"BF\"/>" + 
        					"</w:rPr>" + 
        					"<w:fldChar w:fldCharType=\"begin\"/>" + 
        				"</w:r>" + 
        				"<w:r>" + 
        					"<w:rPr>" + 
        						"<w:color w:val=\"BFBFBF\" w:themeColor=\"background1\" w:themeShade=\"BF\"/>" + 
        					"</w:rPr>" + 
        					"<w:instrText xml:space=\"preserve\"> MERGEFIELD  [#else]  \\* MERGEFORMAT </w:instrText>" + 
        				"</w:r>" + 
        				"<w:r>" + 
        					"<w:rPr>" + 
        						"<w:color w:val=\"BFBFBF\" w:themeColor=\"background1\" w:themeShade=\"BF\"/>" + 
        					"</w:rPr>" + 
        					"<w:fldChar w:fldCharType=\"separate\"/>" + 
        				"</w:r>" + 
        				"<w:r>" + 
        					"<w:rPr>" + 
        						"<w:noProof/>" + 
        						"<w:color w:val=\"BFBFBF\" w:themeColor=\"background1\" w:themeShade=\"BF\"/>" + 
        					"</w:rPr>" + 
        					"<w:t>«[#else]»</w:t>" + 
        				"</w:r>" + 
        				"<w:r>" + 
        					"<w:rPr>" + 
        						"<w:color w:val=\"BFBFBF\" w:themeColor=\"background1\" w:themeShade=\"BF\"/>" + 
        					"</w:rPr>" + 
        					"<w:fldChar w:fldCharType=\"end\"/>" + 
        				"</w:r>" + 
        				"<w:r w:rsidR=\"00421F7D\" w:rsidRPr=\"00E17175\">" + 
        					"<w:t xml:space=\"preserve\">This Product </w:t>" + 
        				"</w:r>" + 
        				"<w:r w:rsidR=\"00A569E0\" w:rsidRPr=\"00E17175\">" + 
        					"<w:t>does not contain any Dual Use Additive</w:t>" + 
        				"</w:r>" + 
        				"<w:r w:rsidR=\"00573066\" w:rsidRPr=\"00E17175\">" + 
        					"<w:t>s</w:t>" + 
        				"</w:r>" + 
        				"<w:r w:rsidR=\"00A569E0\" w:rsidRPr=\"00E17175\">" + 
        					"<w:t>.</w:t>" + 
        				"</w:r>" + 
        				"<w:r w:rsidR=\"00D46C84\">" + 
        					"<w:br/>" + 
        				"</w:r>" + 
        				"<w:r>" + 
        					"<w:rPr>" + 
        						"<w:color w:val=\"BFBFBF\" w:themeColor=\"background1\" w:themeShade=\"BF\"/>" + 
        					"</w:rPr>" + 
        					"<w:fldChar w:fldCharType=\"begin\"/>" + 
        				"</w:r>" + 
        				"<w:r>" + 
        					"<w:rPr>" + 
        						"<w:color w:val=\"BFBFBF\" w:themeColor=\"background1\" w:themeShade=\"BF\"/>" + 
        					"</w:rPr>" + 
        					"<w:instrText xml:space=\"preserve\"> MERGEFIELD  [/#if]  \\* MERGEFORMAT </w:instrText>" + 
        				"</w:r>" + 
        				"<w:r>" + 
        					"<w:rPr>" + 
        						"<w:color w:val=\"BFBFBF\" w:themeColor=\"background1\" w:themeShade=\"BF\"/>" + 
        					"</w:rPr>" + 
        					"<w:fldChar w:fldCharType=\"separate\"/>" + 
        				"</w:r>" + 
        				"<w:r>" + 
        					"<w:rPr>" + 
        						"<w:noProof/>" + 
        						"<w:color w:val=\"BFBFBF\" w:themeColor=\"background1\" w:themeShade=\"BF\"/>" + 
        					"</w:rPr>" + 
        					"<w:t>«[/#if]»</w:t>" + 
        				"</w:r>" + 
        				"<w:r>" + 
        					"<w:rPr>" + 
        						"<w:color w:val=\"BFBFBF\" w:themeColor=\"background1\" w:themeShade=\"BF\"/>" + 
        					"</w:rPr>" + 
        					"<w:fldChar w:fldCharType=\"end\"/>" + 
        				"</w:r>" + 
        				"<w:r w:rsidR=\"00BE6CB1\">" + 
        					"<w:rPr>" + 
        						"<w:color w:val=\"BFBFBF\" w:themeColor=\"background1\" w:themeShade=\"BF\"/>" + 
        					"</w:rPr>" + 
        					"<w:br/>" + 
        				"</w:r>" + 
        			"</w:p>" + 
        			"<w:p w:rsidR=\"00571357\" w:rsidRPr=\"00E17175\" w:rsidRDefault=\"00571357\" w:rsidP=\"00571357\">" + 
        				"<w:pPr>" + 
        					"<w:spacing w:line=\"240\" w:lineRule=\"auto\"/>" + 
        					"<w:rPr>" + 
        						"<w:b/>" + 
        					"</w:rPr>" + 
        				"</w:pPr>" + 
        				"<w:r w:rsidRPr=\"00E17175\">" + 
        					"<w:rPr>" + 
        						"<w:b/>" + 
        					"</w:rPr>" + 
        					"<w:t>8. Specification</w:t>" + 
        				"</w:r>" + 
        				"<w:r w:rsidR=\"00410111\" w:rsidRPr=\"00E17175\">" + 
        					"<w:rPr>" + 
        						"<w:b/>" + 
        					"</w:rPr>" + 
        					"<w:t>s</w:t>" + 
        				"</w:r>" + 
        				"<w:r w:rsidRPr=\"00E17175\">" + 
        					"<w:rPr>" + 
        						"<w:b/>" + 
        					"</w:rPr>" + 
        					"<w:t xml:space=\"preserve\"> </w:t>" + 
        				"</w:r>" + 
        				"<w:r w:rsidR=\"00410111\" w:rsidRPr=\"00E17175\">" + 
        					"<w:rPr>" + 
        						"<w:b/>" + 
        					"</w:rPr>" + 
        					"<w:t>for u</w:t>" + 
        				"</w:r>" + 
        				"<w:r w:rsidRPr=\"00E17175\">" + 
        					"<w:rPr>" + 
        						"<w:b/>" + 
        					"</w:rPr>" + 
        					"<w:t>se</w:t>" + 
        				"</w:r>" + 
        			"</w:p>" + 
        			"<w:p w:rsidR=\"00571357\" w:rsidRPr=\"006F7582\" w:rsidRDefault=\"00417583\" w:rsidP=\"00571357\">" + 
        				"<w:pPr>" + 
        					"<w:spacing w:line=\"240\" w:lineRule=\"auto\"/>" + 
        				"</w:pPr>" + 
        				"<w:r>" + 
        					"<w:rPr>" + 
        						"<w:color w:val=\"BFBFBF\" w:themeColor=\"background1\" w:themeShade=\"BF\"/>" + 
        					"</w:rPr>" + 
        					"<w:br/>" + 
        				"</w:r>" + 
        				"<w:r w:rsidRPr=\"006F7582\">" + 
        					"<w:rPr>" + 
        						"<w:b/>" + 
        					"</w:rPr>" + 
        					"<w:t>Specifications of use as regards of type or types of food</w:t>" + 
        				"</w:r>" + 
        				"<w:r w:rsidR=\"008A568A\">" + 
        					"<w:rPr>" + 
        						"<w:color w:val=\"BFBFBF\" w:themeColor=\"background1\" w:themeShade=\"BF\"/>" + 
        					"</w:rPr>" + 
        					"<w:br/>" + 
        				"</w:r>" + 
        				"<w:r w:rsidR=\"00A40768\">" + 
        					"<w:rPr>" + 
        						"<w:color w:val=\"BFBFBF\" w:themeColor=\"background1\" w:themeShade=\"BF\"/>" + 
        					"</w:rPr>" + 
        					"<w:fldChar w:fldCharType=\"begin\"/>" + 
        				"</w:r>" + 
        				"<w:r w:rsidR=\"00A40768\">" + 
        					"<w:rPr>" + 
        						"<w:color w:val=\"BFBFBF\" w:themeColor=\"background1\" w:themeShade=\"BF\"/>" + 
        					"</w:rPr>" + 
        					"<w:instrText xml:space=\"preserve\"> MERGEFIELD  \"[#if acuFood!?size &gt;0]\"  \\* MERGEFORMAT </w:instrText>" + 
        				"</w:r>" + 
        				"<w:r w:rsidR=\"00A40768\">" + 
        					"<w:rPr>" + 
        						"<w:color w:val=\"BFBFBF\" w:themeColor=\"background1\" w:themeShade=\"BF\"/>" + 
        					"</w:rPr>" + 
        					"<w:fldChar w:fldCharType=\"separate\"/>" + 
        				"</w:r>" + 
        				"<w:r w:rsidR=\"00A40768\">" + 
        					"<w:rPr>" + 
        						"<w:noProof/>" + 
        						"<w:color w:val=\"BFBFBF\" w:themeColor=\"background1\" w:themeShade=\"BF\"/>" + 
        					"</w:rPr>" + 
        					"<w:t>«[#if acuFood!?size &gt;0]»</w:t>" + 
        				"</w:r>" + 
        				"<w:r w:rsidR=\"00A40768\">" + 
        					"<w:rPr>" + 
        						"<w:color w:val=\"BFBFBF\" w:themeColor=\"background1\" w:themeShade=\"BF\"/>" + 
        					"</w:rPr>" + 
        					"<w:fldChar w:fldCharType=\"end\"/>" + 
        				"</w:r>" + 
        			"</w:p>" + 
        			"<w:tbl>" + 
        				"<w:tblPr>" + 
        					"<w:tblStyle w:val=\"TableGrid\"/>" + 
        					"<w:tblW w:w=\"0\" w:type=\"auto\"/>" + 
        					"<w:tblLook w:val=\"04A0\" w:firstRow=\"1\" w:lastRow=\"0\" w:firstColumn=\"1\" w:lastColumn=\"0\" w:noHBand=\"0\" w:noVBand=\"1\"/>" + 
        				"</w:tblPr>" + 
        				"<w:tblGrid>" + 
        					"<w:gridCol w:w=\"9576\"/>" + 
        				"</w:tblGrid>" + 
        				"<w:tr w:rsidR=\"007B0D63\" w:rsidRPr=\"007B0D63\" w:rsidTr=\"00103428\">" + 
        					"<w:tc>" + 
        						"<w:tcPr>" + 
        							"<w:tcW w:w=\"9576\" w:type=\"dxa\"/>" + 
        						"</w:tcPr>" + 
        						"<w:p w:rsidR=\"003E1702\" w:rsidRPr=\"007B0D63\" w:rsidRDefault=\"009E258F\" w:rsidP=\"003E1702\">" + 
        							"<w:r>" + 
        								"<w:fldChar w:fldCharType=\"begin\"/>" + 
        							"</w:r>" + 
        							"<w:r>" + 
        								"<w:instrText xml:space=\"preserve\"> MERGEFIELD  ${acuFood.cond}  \\* MERGEFORMAT </w:instrText>" + 
        							"</w:r>" + 
        							"<w:r>" + 
        								"<w:fldChar w:fldCharType=\"separate\"/>" + 
        							"</w:r>" + 
        							"<w:r w:rsidR=\"008808E3\" w:rsidRPr=\"007B0D63\">" + 
        								"<w:rPr>" + 
        									"<w:noProof/>" + 
        								"</w:rPr>" + 
        								"<w:t>«${acuFood.cond}»</w:t>" + 
        							"</w:r>" + 
        							"<w:r>" + 
        								"<w:rPr>" + 
        									"<w:noProof/>" + 
        								"</w:rPr>" + 
        								"<w:fldChar w:fldCharType=\"end\"/>" + 
        							"</w:r>" + 
        						"</w:p>" + 
        					"</w:tc>" + 
        				"</w:tr>" + 
        			"</w:tbl>" + 
        			"<w:p w:rsidR=\"00571357\" w:rsidRPr=\"00E17175\" w:rsidRDefault=\"00B12D59\" w:rsidP=\"00571357\">" + 
        				"<w:pPr>" + 
        					"<w:spacing w:line=\"240\" w:lineRule=\"auto\"/>" + 
        					"<w:rPr>" + 
        						"<w:color w:val=\"BFBFBF\" w:themeColor=\"background1\" w:themeShade=\"BF\"/>" + 
        					"</w:rPr>" + 
        				"</w:pPr>" + 
        				"<w:r>" + 
        					"<w:rPr>" + 
        						"<w:color w:val=\"BFBFBF\" w:themeColor=\"background1\" w:themeShade=\"BF\"/>" + 
        					"</w:rPr>" + 
        					"<w:fldChar w:fldCharType=\"begin\"/>" + 
        				"</w:r>" + 
        				"<w:r>" + 
        					"<w:rPr>" + 
        						"<w:color w:val=\"BFBFBF\" w:themeColor=\"background1\" w:themeShade=\"BF\"/>" + 
        					"</w:rPr>" + 
        					"<w:instrText xml:space=\"preserve\"> MERGEFIELD  [#else]  \\* MERGEFORMAT </w:instrText>" + 
        				"</w:r>" + 
        				"<w:r>" + 
        					"<w:rPr>" + 
        						"<w:color w:val=\"BFBFBF\" w:themeColor=\"background1\" w:themeShade=\"BF\"/>" + 
        					"</w:rPr>" + 
        					"<w:fldChar w:fldCharType=\"separate\"/>" + 
        				"</w:r>" + 
        				"<w:r>" + 
        					"<w:rPr>" + 
        						"<w:noProof/>" + 
        						"<w:color w:val=\"BFBFBF\" w:themeColor=\"background1\" w:themeShade=\"BF\"/>" + 
        					"</w:rPr>" + 
        					"<w:t>«[#else]»</w:t>" + 
        				"</w:r>" + 
        				"<w:r>" + 
        					"<w:rPr>" + 
        						"<w:color w:val=\"BFBFBF\" w:themeColor=\"background1\" w:themeShade=\"BF\"/>" + 
        					"</w:rPr>" + 
        					"<w:fldChar w:fldCharType=\"end\"/>" + 
        				"</w:r>" + 
        			"</w:p>" + 
        			"<w:p w:rsidR=\"00571357\" w:rsidRPr=\"00E17175\" w:rsidRDefault=\"000820D7\" w:rsidP=\"00571357\">" + 
        				"<w:pPr>" + 
        					"<w:spacing w:line=\"240\" w:lineRule=\"auto\"/>" + 
        				"</w:pPr>" + 
        				"<w:r w:rsidRPr=\"00E17175\">" + 
        					"<w:t>None</w:t>" + 
        				"</w:r>" + 
        			"</w:p>" + 
        			"<w:p w:rsidR=\"00571357\" w:rsidRPr=\"00E17175\" w:rsidRDefault=\"00B12D59\" w:rsidP=\"00571357\">" + 
        				"<w:pPr>" + 
        					"<w:spacing w:line=\"240\" w:lineRule=\"auto\"/>" + 
        					"<w:rPr>" + 
        						"<w:color w:val=\"BFBFBF\" w:themeColor=\"background1\" w:themeShade=\"BF\"/>" + 
        					"</w:rPr>" + 
        				"</w:pPr>" + 
        				"<w:r>" + 
        					"<w:rPr>" + 
        						"<w:color w:val=\"BFBFBF\" w:themeColor=\"background1\" w:themeShade=\"BF\"/>" + 
        					"</w:rPr>" + 
        					"<w:fldChar w:fldCharType=\"begin\"/>" + 
        				"</w:r>" + 
        				"<w:r>" + 
        					"<w:rPr>" + 
        						"<w:color w:val=\"BFBFBF\" w:themeColor=\"background1\" w:themeShade=\"BF\"/>" + 
        					"</w:rPr>" + 
        					"<w:instrText xml:space=\"preserve\"> MERGEFIELD  [/#if]  \\* MERGEFORMAT </w:instrText>" + 
        				"</w:r>" + 
        				"<w:r>" + 
        					"<w:rPr>" + 
        						"<w:color w:val=\"BFBFBF\" w:themeColor=\"background1\" w:themeShade=\"BF\"/>" + 
        					"</w:rPr>" + 
        					"<w:fldChar w:fldCharType=\"separate\"/>" + 
        				"</w:r>" + 
        				"<w:r>" + 
        					"<w:rPr>" + 
        						"<w:noProof/>" + 
        						"<w:color w:val=\"BFBFBF\" w:themeColor=\"background1\" w:themeShade=\"BF\"/>" + 
        					"</w:rPr>" + 
        					"<w:t>«[/#if]»</w:t>" + 
        				"</w:r>" + 
        				"<w:r>" + 
        					"<w:rPr>" + 
        						"<w:color w:val=\"BFBFBF\" w:themeColor=\"background1\" w:themeShade=\"BF\"/>" + 
        					"</w:rPr>" + 
        					"<w:fldChar w:fldCharType=\"end\"/>" + 
        				"</w:r>" + 
        			"</w:p>" + 
        			"<w:p w:rsidR=\"00571357\" w:rsidRPr=\"00E17175\" w:rsidRDefault=\"00417583\" w:rsidP=\"00571357\">" + 
        				"<w:pPr>" + 
        					"<w:spacing w:line=\"240\" w:lineRule=\"auto\"/>" + 
        					"<w:rPr>" + 
        						"<w:b/>" + 
        					"</w:rPr>" + 
        				"</w:pPr>" + 
        				"<w:r>" + 
        					"<w:rPr>" + 
        						"<w:b/>" + 
        					"</w:rPr>" + 
        					"<w:br/>" + 
        				"</w:r>" + 
        				"<w:r w:rsidRPr=\"00250FF1\">" + 
        					"<w:rPr>" + 
        						"<w:b/>" + 
        					"</w:rPr>" + 
        					"<w:t>Specifications for use as regards of time and temperature of treatment and storage of food</w:t>" + 
        				"</w:r>" + 
        			"</w:p>" + 
        			"<w:p w:rsidR=\"00571357\" w:rsidRPr=\"00E17175\" w:rsidRDefault=\"007B0D63\" w:rsidP=\"00571357\">" + 
        				"<w:pPr>" + 
        					"<w:spacing w:line=\"240\" w:lineRule=\"auto\"/>" + 
        					"<w:rPr>" + 
        						"<w:color w:val=\"BFBFBF\" w:themeColor=\"background1\" w:themeShade=\"BF\"/>" + 
        					"</w:rPr>" + 
        				"</w:pPr>" + 
        				"<w:r>" + 
        					"<w:rPr>" + 
        						"<w:color w:val=\"BFBFBF\" w:themeColor=\"background1\" w:themeShade=\"BF\"/>" + 
        					"</w:rPr>" + 
        					"<w:fldChar w:fldCharType=\"begin\"/>" + 
        				"</w:r>" + 
        				"<w:r>" + 
        					"<w:rPr>" + 
        						"<w:color w:val=\"BFBFBF\" w:themeColor=\"background1\" w:themeShade=\"BF\"/>" + 
        					"</w:rPr>" + 
        					"<w:instrText xml:space=\"preserve\"> MERGEFIELD  \"[#if acuTimeTemp!?size &gt;0]\"  \\* MERGEFORMAT </w:instrText>" + 
        				"</w:r>" + 
        				"<w:r>" + 
        					"<w:rPr>" + 
        						"<w:color w:val=\"BFBFBF\" w:themeColor=\"background1\" w:themeShade=\"BF\"/>" + 
        					"</w:rPr>" + 
        					"<w:fldChar w:fldCharType=\"separate\"/>" + 
        				"</w:r>" + 
        				"<w:r>" + 
        					"<w:rPr>" + 
        						"<w:noProof/>" + 
        						"<w:color w:val=\"BFBFBF\" w:themeColor=\"background1\" w:themeShade=\"BF\"/>" + 
        					"</w:rPr>" + 
        					"<w:t>«[#if acuTimeTemp!?size &gt;0]»</w:t>" + 
        				"</w:r>" + 
        				"<w:r>" + 
        					"<w:rPr>" + 
        						"<w:color w:val=\"BFBFBF\" w:themeColor=\"background1\" w:themeShade=\"BF\"/>" + 
        					"</w:rPr>" + 
        					"<w:fldChar w:fldCharType=\"end\"/>" + 
        				"</w:r>" + 
        			"</w:p>" + 
        			"<w:tbl>" + 
        				"<w:tblPr>" + 
        					"<w:tblStyle w:val=\"TableGrid\"/>" + 
        					"<w:tblW w:w=\"0\" w:type=\"auto\"/>" + 
        					"<w:tblLook w:val=\"04A0\" w:firstRow=\"1\" w:lastRow=\"0\" w:firstColumn=\"1\" w:lastColumn=\"0\" w:noHBand=\"0\" w:noVBand=\"1\"/>" + 
        				"</w:tblPr>" + 
        				"<w:tblGrid>" + 
        					"<w:gridCol w:w=\"9576\"/>" + 
        				"</w:tblGrid>" + 
        				"<w:tr w:rsidR=\"003E1702\" w:rsidRPr=\"00E17175\" w:rsidTr=\"00103428\">" + 
        					"<w:tc>" + 
        						"<w:tcPr>" + 
        							"<w:tcW w:w=\"9576\" w:type=\"dxa\"/>" + 
        						"</w:tcPr>" + 
        						"<w:p w:rsidR=\"003E1702\" w:rsidRPr=\"00E00F75\" w:rsidRDefault=\"009E258F\" w:rsidP=\"00103428\">" + 
        							"<w:r>" + 
        								"<w:fldChar w:fldCharType=\"begin\"/>" + 
        							"</w:r>" + 
        							"<w:r>" + 
        								"<w:instrText xml:space=\"preserve\"> MERGEFIELD  ${acuTimeTemp.cond}  \\* MERGEFORMAT </w:instrText>" + 
        							"</w:r>" + 
        							"<w:r>" + 
        								"<w:fldChar w:fldCharType=\"separate\"/>" + 
        							"</w:r>" + 
        							"<w:r w:rsidR=\"00E00F75\">" + 
        								"<w:rPr>" + 
        									"<w:noProof/>" + 
        								"</w:rPr>" + 
        								"<w:t>«${acuTimeTemp.cond}»</w:t>" + 
        							"</w:r>" + 
        							"<w:r>" + 
        								"<w:rPr>" + 
        									"<w:noProof/>" + 
        								"</w:rPr>" + 
        								"<w:fldChar w:fldCharType=\"end\"/>" + 
        							"</w:r>" + 
        						"</w:p>" + 
        					"</w:tc>" + 
        				"</w:tr>" + 
        			"</w:tbl>" + 
        			"<w:p w:rsidR=\"00571357\" w:rsidRPr=\"00E17175\" w:rsidRDefault=\"007B0D63\" w:rsidP=\"00571357\">" + 
        				"<w:pPr>" + 
        					"<w:spacing w:line=\"240\" w:lineRule=\"auto\"/>" + 
        					"<w:rPr>" + 
        						"<w:color w:val=\"BFBFBF\" w:themeColor=\"background1\" w:themeShade=\"BF\"/>" + 
        					"</w:rPr>" + 
        				"</w:pPr>" + 
        				"<w:r>" + 
        					"<w:rPr>" + 
        						"<w:color w:val=\"BFBFBF\" w:themeColor=\"background1\" w:themeShade=\"BF\"/>" + 
        					"</w:rPr>" + 
        					"<w:fldChar w:fldCharType=\"begin\"/>" + 
        				"</w:r>" + 
        				"<w:r>" + 
        					"<w:rPr>" + 
        						"<w:color w:val=\"BFBFBF\" w:themeColor=\"background1\" w:themeShade=\"BF\"/>" + 
        					"</w:rPr>" + 
        					"<w:instrText xml:space=\"preserve\"> MERGEFIELD  [#else]  \\* MERGEFORMAT </w:instrText>" + 
        				"</w:r>" + 
        				"<w:r>" + 
        					"<w:rPr>" + 
        						"<w:color w:val=\"BFBFBF\" w:themeColor=\"background1\" w:themeShade=\"BF\"/>" + 
        					"</w:rPr>" + 
        					"<w:fldChar w:fldCharType=\"separate\"/>" + 
        				"</w:r>" + 
        				"<w:r>" + 
        					"<w:rPr>" + 
        						"<w:noProof/>" + 
        						"<w:color w:val=\"BFBFBF\" w:themeColor=\"background1\" w:themeShade=\"BF\"/>" + 
        					"</w:rPr>" + 
        					"<w:t>«[#else]»</w:t>" + 
        				"</w:r>" + 
        				"<w:r>" + 
        					"<w:rPr>" + 
        						"<w:color w:val=\"BFBFBF\" w:themeColor=\"background1\" w:themeShade=\"BF\"/>" + 
        					"</w:rPr>" + 
        					"<w:fldChar w:fldCharType=\"end\"/>" + 
        				"</w:r>" + 
        			"</w:p>" + 
        			"<w:p w:rsidR=\"00571357\" w:rsidRPr=\"00250FF1\" w:rsidRDefault=\"003E1702\" w:rsidP=\"00571357\">" + 
        				"<w:pPr>" + 
        					"<w:spacing w:line=\"240\" w:lineRule=\"auto\"/>" + 
        				"</w:pPr>" + 
        				"<w:r w:rsidRPr=\"00250FF1\">" + 
        					"<w:t>None</w:t>" + 
        				"</w:r>" + 
        			"</w:p>" + 
        			"<w:p w:rsidR=\"00571357\" w:rsidRPr=\"00E17175\" w:rsidRDefault=\"007B0D63\" w:rsidP=\"00571357\">" + 
        				"<w:pPr>" + 
        					"<w:spacing w:line=\"240\" w:lineRule=\"auto\"/>" + 
        					"<w:rPr>" + 
        						"<w:color w:val=\"BFBFBF\" w:themeColor=\"background1\" w:themeShade=\"BF\"/>" + 
        					"</w:rPr>" + 
        				"</w:pPr>" + 
        				"<w:r>" + 
        					"<w:rPr>" + 
        						"<w:color w:val=\"BFBFBF\" w:themeColor=\"background1\" w:themeShade=\"BF\"/>" + 
        					"</w:rPr>" + 
        					"<w:fldChar w:fldCharType=\"begin\"/>" + 
        				"</w:r>" + 
        				"<w:r>" + 
        					"<w:rPr>" + 
        						"<w:color w:val=\"BFBFBF\" w:themeColor=\"background1\" w:themeShade=\"BF\"/>" + 
        					"</w:rPr>" + 
        					"<w:instrText xml:space=\"preserve\"> MERGEFIELD  [/#if]  \\* MERGEFORMAT </w:instrText>" + 
        				"</w:r>" + 
        				"<w:r>" + 
        					"<w:rPr>" + 
        						"<w:color w:val=\"BFBFBF\" w:themeColor=\"background1\" w:themeShade=\"BF\"/>" + 
        					"</w:rPr>" + 
        					"<w:fldChar w:fldCharType=\"separate\"/>" + 
        				"</w:r>" + 
        				"<w:r>" + 
        					"<w:rPr>" + 
        						"<w:noProof/>" + 
        						"<w:color w:val=\"BFBFBF\" w:themeColor=\"background1\" w:themeShade=\"BF\"/>" + 
        					"</w:rPr>" + 
        					"<w:t>«[/#if]»</w:t>" + 
        				"</w:r>" + 
        				"<w:r>" + 
        					"<w:rPr>" + 
        						"<w:color w:val=\"BFBFBF\" w:themeColor=\"background1\" w:themeShade=\"BF\"/>" + 
        					"</w:rPr>" + 
        					"<w:fldChar w:fldCharType=\"end\"/>" + 
        				"</w:r>" + 
        			"</w:p>" + 
        			"<w:p w:rsidR=\"000820D7\" w:rsidRPr=\"00E17175\" w:rsidRDefault=\"00E97283\" w:rsidP=\"00571357\">" + 
        				"<w:pPr>" + 
        					"<w:spacing w:line=\"240\" w:lineRule=\"auto\"/>" + 
        					"<w:rPr>" + 
        						"<w:b/>" + 
        					"</w:rPr>" + 
        				"</w:pPr>" + 
        				"<w:r>" + 
        					"<w:rPr>" + 
        						"<w:b/>" + 
        					"</w:rPr>" + 
        					"<w:br/>" + 
        				"</w:r>" + 
        				"<w:r w:rsidRPr=\"00250FF1\">" + 
        					"<w:rPr>" + 
        						"<w:b/>" + 
        					"</w:rPr>" + 
        					"<w:t>Any other limitations of use</w:t>" + 
        				"</w:r>" + 
        			"</w:p>" + 
        			"<w:p w:rsidR=\"00571357\" w:rsidRPr=\"00E17175\" w:rsidRDefault=\"00D84AC9\" w:rsidP=\"00571357\">" + 
        				"<w:pPr>" + 
        					"<w:spacing w:line=\"240\" w:lineRule=\"auto\"/>" + 
        					"<w:rPr>" + 
        						"<w:color w:val=\"BFBFBF\" w:themeColor=\"background1\" w:themeShade=\"BF\"/>" + 
        					"</w:rPr>" + 
        				"</w:pPr>" + 
        				"<w:r>" + 
        					"<w:rPr>" + 
        						"<w:color w:val=\"BFBFBF\" w:themeColor=\"background1\" w:themeShade=\"BF\"/>" + 
        					"</w:rPr>" + 
        					"<w:fldChar w:fldCharType=\"begin\"/>" + 
        				"</w:r>" + 
        				"<w:r>" + 
        					"<w:rPr>" + 
        						"<w:color w:val=\"BFBFBF\" w:themeColor=\"background1\" w:themeShade=\"BF\"/>" + 
        					"</w:rPr>" + 
        					"<w:instrText xml:space=\"preserve\"> MERGEFIELD  \"[#if acuOther!?size &gt;0]\"  \\* MERGEFORMAT </w:instrText>" + 
        				"</w:r>" + 
        				"<w:r>" + 
        					"<w:rPr>" + 
        						"<w:color w:val=\"BFBFBF\" w:themeColor=\"background1\" w:themeShade=\"BF\"/>" + 
        					"</w:rPr>" + 
        					"<w:fldChar w:fldCharType=\"separate\"/>" + 
        				"</w:r>" + 
        				"<w:r>" + 
        					"<w:rPr>" + 
        						"<w:noProof/>" + 
        						"<w:color w:val=\"BFBFBF\" w:themeColor=\"background1\" w:themeShade=\"BF\"/>" + 
        					"</w:rPr>" + 
        					"<w:t>«[#if acuOther!?size &gt;0]»</w:t>" + 
        				"</w:r>" + 
        				"<w:r>" + 
        					"<w:rPr>" + 
        						"<w:color w:val=\"BFBFBF\" w:themeColor=\"background1\" w:themeShade=\"BF\"/>" + 
        					"</w:rPr>" + 
        					"<w:fldChar w:fldCharType=\"end\"/>" + 
        				"</w:r>" + 
        			"</w:p>" + 
        			"<w:tbl>" + 
        				"<w:tblPr>" + 
        					"<w:tblStyle w:val=\"TableGrid\"/>" + 
        					"<w:tblW w:w=\"0\" w:type=\"auto\"/>" + 
        					"<w:tblLook w:val=\"04A0\" w:firstRow=\"1\" w:lastRow=\"0\" w:firstColumn=\"1\" w:lastColumn=\"0\" w:noHBand=\"0\" w:noVBand=\"1\"/>" + 
        				"</w:tblPr>" + 
        				"<w:tblGrid>" + 
        					"<w:gridCol w:w=\"9576\"/>" + 
        				"</w:tblGrid>" + 
        				"<w:tr w:rsidR=\"003E1702\" w:rsidRPr=\"00E17175\" w:rsidTr=\"00103428\">" + 
        					"<w:tc>" + 
        						"<w:tcPr>" + 
        							"<w:tcW w:w=\"9576\" w:type=\"dxa\"/>" + 
        						"</w:tcPr>" + 
        						"<w:p w:rsidR=\"003E1702\" w:rsidRPr=\"00E17175\" w:rsidRDefault=\"009E258F\" w:rsidP=\"00103428\">" + 
        							"<w:pPr>" + 
        								"<w:rPr>" + 
        									"<w:color w:val=\"BFBFBF\" w:themeColor=\"background1\" w:themeShade=\"BF\"/>" + 
        								"</w:rPr>" + 
        							"</w:pPr>" + 
        							"<w:r>" + 
        								"<w:fldChar w:fldCharType=\"begin\"/>" + 
        							"</w:r>" + 
        							"<w:r>" + 
        								"<w:instrText xml:space=\"preserve\"> MERGEFIELD  ${acuOther.cond}  \\* MER</w:instrText>" + 
        							"</w:r>" + 
        							"<w:r>" + 
        								"<w:instrText xml:space=\"preserve\">GEFORMAT </w:instrText>" + 
        							"</w:r>" + 
        							"<w:r>" + 
        								"<w:fldChar w:fldCharType=\"separate\"/>" + 
        							"</w:r>" + 
        							"<w:r w:rsidR=\"00D84AC9\" w:rsidRPr=\"00021809\">" + 
        								"<w:rPr>" + 
        									"<w:noProof/>" + 
        								"</w:rPr>" + 
        								"<w:t>«${acuOther.cond}»</w:t>" + 
        							"</w:r>" + 
        							"<w:r>" + 
        								"<w:rPr>" + 
        									"<w:noProof/>" + 
        								"</w:rPr>" + 
        								"<w:fldChar w:fldCharType=\"end\"/>" + 
        							"</w:r>" + 
        						"</w:p>" + 
        					"</w:tc>" + 
        				"</w:tr>" + 
        			"</w:tbl>" + 
        			"<w:p w:rsidR=\"00012B7E\" w:rsidRPr=\"00CB0531\" w:rsidRDefault=\"00D84D6D\" w:rsidP=\"00012B7E\">" + 
        				"<w:pPr>" + 
        					"<w:spacing w:line=\"240\" w:lineRule=\"auto\"/>" + 
        				"</w:pPr>" + 
        				"<w:r>" + 
        					"<w:rPr>" + 
        						"<w:color w:val=\"BFBFBF\" w:themeColor=\"background1\" w:themeShade=\"BF\"/>" + 
        					"</w:rPr>" + 
        					"<w:fldChar w:fldCharType=\"begin\"/>" + 
        				"</w:r>" + 
        				"<w:r>" + 
        					"<w:rPr>" + 
        						"<w:color w:val=\"BFBFBF\" w:themeColor=\"background1\" w:themeShade=\"BF\"/>" + 
        					"</w:rPr>" + 
        					"<w:instrText xml:space=\"preserve\"> MERGEFIELD  [/#if]  \\* MERGEFORMAT </w:instrText>" + 
        				"</w:r>" + 
        				"<w:r>" + 
        					"<w:rPr>" + 
        						"<w:color w:val=\"BFBFBF\" w:themeColor=\"background1\" w:themeShade=\"BF\"/>" + 
        					"</w:rPr>" + 
        					"<w:fldChar w:fldCharType=\"separate\"/>" + 
        				"</w:r>" + 
        				"<w:r>" + 
        					"<w:rPr>" + 
        						"<w:noProof/>" + 
        						"<w:color w:val=\"BFBFBF\" w:themeColor=\"background1\" w:themeShade=\"BF\"/>" + 
        					"</w:rPr>" + 
        					"<w:t>«[/#if]»</w:t>" + 
        				"</w:r>" + 
        				"<w:r>" + 
        					"<w:rPr>" + 
        						"<w:color w:val=\"BFBFBF\" w:themeColor=\"background1\" w:themeShade=\"BF\"/>" + 
        					"</w:rPr>" + 
        					"<w:fldChar w:fldCharType=\"end\"/>" + 
        				"</w:r>" + 
        			"</w:p>" + 
        			"<w:sectPr w:rsidR=\"00012B7E\" w:rsidRPr=\"00CB0531\" w:rsidSect=\"00B4663A\">" + 
        				"<w:pgSz w:w=\"12240\" w:h=\"15840\"/>" + 
        				"<w:pgMar w:top=\"1440\" w:right=\"1440\" w:bottom=\"1440\" w:left=\"1440\" w:header=\"720\" w:footer=\"720\" w:gutter=\"0\"/>" + 
        				"<w:cols w:space=\"720\"/>" + 
        				"<w:docGrid w:linePitch=\"360\"/>" + 
        			"</w:sectPr>" + 
        		"</w:body>" + 
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
