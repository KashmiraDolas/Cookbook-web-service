import json
import csv

fdata = []

with open("epi_r_edited.csv", "r", errors='ignore') as csvfile:
    read_csv = csv.reader(csvfile, delimiter=',')
    header = next(read_csv)
    # [pima.append([header[i]]) for i in range (len(header))]
    #[pima.append([]) for i in range(len(header))]
    print(header)
    #for rows in read_csv:
    #    [pima[i].append(float(rows[i])) for i in range(len(header))]
    for rows in read_csv:
        fdata.append(rows)
    print(fdata[0][1])

print(len(fdata)+1)

with open('full_format_recipes.json') as data_file:
    data = json.loads(data_file.read())
print(data[0]["title"])



jdata = []

for i in range (len(data)):
    if len(data[i]) != 0:
        el_id = i
        el_title = data[i]["title"]
        str_directions = ""
        for i in data[i]["directions"]:
            str_directions += i + " "

        s = unicode(str_directions, "utf-8")
        el_directions = s
        jdata.append([el_id, el_title, el_directions])
print(jdata[5])


with open("directions_data.csv", 'w', encoding='utf-8') as f:
    write = csv.writer(f, delimiter=',')
    for rows in jdata:

        write.writerow(rows)

with open("receipe_data.csv", 'w', encoding='utf-8') as f:
    write = csv.writer(f, delimiter=',')
    for rows in fdata:
        write.writerow(rows)
