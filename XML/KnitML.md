# KnitML Tags

Referenced from: http://www.knitml.com/docs/users-guide.html

| Tag | Description | Etc. |
| --- | ----------- | ---------- | 
| author | The name (or username) of pattern author | `<author>Sebastian Greenholtz</author>` |
| ball-weight | The weight of a single ball of yarn. | `<ball-weight unit='g'>50</ball-weight>` | 
| bind-off | Bind off specificed number of stitches | `<bind-off>50</bind-off>` |
| bind-off-all | Bind off all stitches on needles | `<bind-off-all />` |
| cast-on | Cast the number of stitches onto the current needle. | |
| declare-flat-knitting | Declare begin knitting flat | `<declare-flat-knitting />` |
| declare-round-knitting | Declare begin knitting in the round | `<declare-round-knitting />` |
| decrease | Decrease using stitch of specified type | `<decrease type="k2tog" />` |
| dimensions | Final pattern dimensions, rendered as free text | `<dimensions>2.5 in tall, 3.5 in wide</dimensions>` |
| directions | Pattern directions | |
| from-stitch-holder | Follow instructions following the stitch holder | |
| gauge | Instructions for the gauge | `<gauge type="stockinette">...</gauge>` |
| general-information | General information about the pattern | |
| increase | Increase using stitch of specified type | `<increase type="yo" />` |
| knit | Knit specified stitches or until end | `<knit>50</knit>` | 
|      |                                      | `<repeat until="end"><knit /></repeat>` |
| materials | Materials needed to completed the pattern | |
| needle | Needle for use in pattern, specify type circular or default to flat | `<needle type="circular" />` |
| notion | Any notion withotu a specific tag | `<notion type="button" quantity="3" />` |
| purl | Purl specified stitches or until end | `<purl>2</purl>` |
| pattern | Pattern written in specified ISO language code | `<pattern xsl:lang="em">...</pattern>` |
| pick-up-stitches | Pick up stitches in indicated direction | `<pick-up-stitches type="purlwise">10</pick-up-stitches>` |
| place-marker | Place a stitch marker | `<place-marker />` |
| remove-marker| Remove a stitch marker | `<remove-marker />` |
| repeat | Repeat enclosed instructions specified number of times or until end | `<repeat until="times" value="3">...</repeat>`|
| row | A single row of a pattern, given a number identifyer | `<row number="1">...</row>` |
| size | For use with needle, specify unit US or mm | `<size unit="US">6</size>` |
| slip | Slip the specified number of stitches, specify knitwise or purlwise | `<slip type="knitwise>2</slip>` |
| stitch | Any stitch without its own tag, can be ref'd if previously defined | `<stitch type="Kitchener" ref="kitchener" symbol="kt" />` |
| stitch-definition | Stitch definition for unusual or special stitches | `<stitch-definition ref="ssk">Slip two stitches as if to knit...</stitch-definition>` |
| stitch-gauge | The number of stitches (horizontally) per unit of measurement | `<stitch-gauge unit="st/in">3.5</stitch-gauge>` |
| title | The pattern or project title | |
| yarn | A yarn used in the pattern. Typeref must be already define in yarn-type | `<yarn id="y1" label="Main Color" symbol="MC" typeref="wool"> ... </yarn>` |
| yarn-over | Yarn over the crochet hook | |
| yarn-type | Define a type of yarn for use in the project | `<yarn-type id="wool" brand="Lorna's Laces" weight="fingering"/>...</yarn-type>` |
