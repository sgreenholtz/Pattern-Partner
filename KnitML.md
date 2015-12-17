# KnitML Tags

Referenced from: http://www.knitml.com/docs/users-guide.html

| Tag | Description | Etc. |
| --- | ----------- | ---------- | 
| ball-weight | The weight of a single ball of yarn. | `<ball-weight unit='g'>50</ball-weight>` | 
| bind-off | Bind off specificed number of stitches | `<bind-off>50</bind-off>` |
| bind-off-all | Bind off all stitches on needles | `<bind-off-all />` |
| cast-on | Cast the number of stitches onto the current needle. | |
| declare-flat-knitting | Declare begin knitting flat | `<declare-flat-knitting />` |
| declare-round-knitting | Declare begin knitting in the round | `<declare-round-knitting />` |
| directions | Pattern directions | |
| from-stitch-holder | Follow instructions following the stitch holder | |
| gauge | Instructions for the gauge | `<gauge type="stockinette">...</gauge>` |
| general-information | General information about the pattern | |
| knit | Knit specified stitches or until end | `<knit>50</knit>` | `<repeat until="end"><knit /></repeat>` |
<table>
  <tr>
    <th>Tag</th>
    <th>Decsription</th>
    <th>Etc</th>
  </tr>
  <tr>
    <td>ball-weight<td>
    <td>The weight of a single ball of yarn</td>
    <td>`<ball-weight unit='g'>50</ball-weight>`</td>
  </tr>
  <tr>
    <td>knit</td>
    <td>Knit specified stitches or until end</td>
    <td rowspan="2">
      `<knit>50</knit>`
      `<repeat until="end"><knit /></repeat>`
    </td>
  </tr>
</table>
