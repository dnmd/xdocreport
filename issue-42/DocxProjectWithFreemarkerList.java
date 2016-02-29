package fr.opensagres.xdocreport.samples.docxandfreemarker;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import fr.opensagres.xdocreport.converter.ConverterTypeTo;
import fr.opensagres.xdocreport.converter.ConverterTypeVia;
import fr.opensagres.xdocreport.converter.Options;
import fr.opensagres.xdocreport.core.XDocReportException;
import fr.opensagres.xdocreport.core.document.SyntaxKind;
import fr.opensagres.xdocreport.document.IXDocReport;
import fr.opensagres.xdocreport.document.registry.XDocReportRegistry;
import fr.opensagres.xdocreport.template.IContext;
import fr.opensagres.xdocreport.template.TemplateEngineKind;
import fr.opensagres.xdocreport.template.formatter.FieldsMetadata;

public class DocxProjectWithFreemarkerList
{

    @SuppressWarnings("serial")
	public static void main( String[] args )
    {
        try
        {
			
			// Add a space, remove the space, save the document and it will FAIL.
			// REM LINE 72 AND IT WORKS.
			/* THIS DOCUMENT.XML FAILS
				<w:r>
					<w:fldChar w:fldCharType="begin"/>
				</w:r>
				<w:r>
					<w:instrText xml:space="preserve"> MERGEFIELD  ${acuOther.cond}  \* MER</w:instrText>
				</w:r>
				<w:r>
					<w:instrText xml:space="preserve">GEFORMAT </w:instrText>
				</w:r>
				<w:r>
					<w:fldChar w:fldCharType="separate"/>
				</w:r>
			*/
			
			// Add a space, remove the space, save the document and it will WORK.
			/* THIS DOCUMENT.XML WORKS
				<w:fldSimple w:instr=" MERGEFIELD  ${acuOther.cond}  \* MERGEFORMAT ">
					<w:r w:rsidR="00D84AC9" w:rsidRPr="00021809">
						<w:rPr>
							<w:noProof/>
						</w:rPr>
						<w:t>«${acuOther.cond}»</w:t>
					</w:r>
				</w:fldSimple>
			*/
			
            InputStream in = DocxProjectWithFreemarker.class.getResourceAsStream( "DocxProjectWithFreemarkerList.docx" );
            IXDocReport report = XDocReportRegistry.getRegistry().loadReport( in, TemplateEngineKind.Freemarker );

            FieldsMetadata metadata = new FieldsMetadata();
			
			metadata.addFieldAsList("acuOther.cond");
			
			// When it FAILS, it breaks on this line!
			// Disable this line on a document that fails, and it WORKS again.
			metadata.addFieldAsTextStyling("acuOther.cond", SyntaxKind.Html);
			// ....			
			
			Set<Map<String, String>> allOther = new HashSet<Map<String, String>>(){{
				add(new HashMap<String, String>(){{
					put("cond", "<p>Some markup inside a tablerow...<br />Next line!</p>");
					put("cond", "<p>Another line with markupi inside tablerow...<br />Next line!</p>");					
				}});
			}};
		
			report.setFieldsMetadata(metadata);

			IContext context = report.createContext();
		  			 context.put("acuOther", allOther );
		  	
		  	Options	options = Options.getTo(ConverterTypeTo.PDF).via(ConverterTypeVia.XWPF);
		  	
            OutputStream out = new FileOutputStream( new File( "DocxProjectWithFreemarkerList_" + Long.toString( new Date().getTime() ) + ".pdf" ) );
            report.convert( context, options, out );

        }
        catch ( IOException e )
        {
            e.printStackTrace();
        }
        catch ( XDocReportException e )
        {
            e.printStackTrace();
        }
    }
}
