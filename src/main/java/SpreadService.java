import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.sort;

/**
 * SpreadService implementation class.
 * Created By: Troy Whittier
 */
public class SpreadService
{
    @SuppressWarnings("unchecked")
    public Stats findMinSpread(String filename, int[] fields) throws IOException
    {
        File file = new File(filename);
        if (!file.exists()) {
            throw new RuntimeException("File does not exist: " + filename);
        }

        List<String> lines = FileUtils.readLines(file);
        List<Stats> list = new ArrayList<Stats>();
        for (String line : lines) {
            String[] elements = StringUtils.split(line, " ");
            Stats status = mapToStats(elements, fields);
            if (status != null) {
                list.add(status);
            }
        }
        sort(list);
        return list.get(0);
    }

    public Stats mapToStats(String[] elements, int[] fields) {
        if (elements.length <= fields[2]) {
            return null;
        }
        try {
            parseInt(elements[0]);
        } catch (Exception e) {
            return null;
        }
        Stats status = new Stats();
        status.setName(elements[fields[0]]);
        status.setMax(parseInt(elements[fields[1]]));
        status.setMin(parseInt(elements[fields[2]]));
        return status;

    }

    private int parseInt(String element) {
        String clean = element.replace('.', ' ');
        clean = clean.replace('*', ' ');
        return Integer.parseInt(StringUtils.trim(clean));
    }

}
