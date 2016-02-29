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
import fr.opensagres.xdocreport.document.IXDocReport;
import fr.opensagres.xdocreport.document.registry.XDocReportRegistry;
import fr.opensagres.xdocreport.template.IContext;
import fr.opensagres.xdocreport.template.TemplateEngineKind;
import fr.opensagres.xdocreport.template.formatter.FieldsMetadata;

public class DocxProjectWithFreemarkerList
{

    @SuppressWarnings("serial")
    public static void main(String[] args) {
    {
        try
        {
			
			// Add a space, remove the space, save the document and it will FAIL.
			/* DOCUMENT.XML FAILS
			 * 
				<w:r>
					<w:instrText xml:space="preserve"> MERGEFIELD  ${du.name</w:instrText>
				</w:r>
				<w:r>
					<w:instrText xml:space="preserve">}  \* MERGEFORMAT </w:instrText>
				</w:r>
				
				============= OR =============
				
				<w:r>
					<w:instrText xml:space="preserve"> MERGEFIELD  $</w:instrText>
				</w:r>
				<w:r>
					<w:instrText xml:space="preserve">{du.name}  \* MERGEFORMAT </w:instrText>
				</w:r>			
			*
			*/
			
            InputStream in = DocxProjectWithFreemarker.class.getResourceAsStream( "issue-119-failing.docx" );
            IXDocReport report = XDocReportRegistry.getRegistry().loadReport( in, TemplateEngineKind.Freemarker );

            FieldsMetadata metadata = new FieldsMetadata();
			
			metadata.addFieldAsList("du.no");					
			
			Set<Map<String, String>> dua = new HashSet<Map<String, String>>(){{
				add(new HashMap<String, String>(){{
					put("no", "no 1");		
				}});
			}};
		
			report.setFieldsMetadata(metadata);

			IContext context = report.createContext();
		  			 context.put("du", dua );
		  	
		  	Options	options = Options.getTo(ConverterTypeTo.PDF).via(ConverterTypeVia.XWPF);
		  	
            OutputStream out = new FileOutputStream( new File( "issue-119-failing_" + Long.toString( new Date().getTime() ) + ".pdf" ) );

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
