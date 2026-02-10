# TODO:

- Teste mit log ob jobs empfangen werden von der api (falls nicht -> fehler fixen)
- controller von jobservice fertigstellen
- Response Dto auch in dem service definieren (auch erstellen)
- ggf BulkIngestResponse erstellen (der anzeigt wie viele angekommen, created und geskipped worden sind)

- service beginnen von jobservice
  - für jeden job (aus aggregated jobs) prüfen ob:
    - dieser schon existeirt (dedup)
    - falls nciht in die datenbank speichern
    - repository erstellen